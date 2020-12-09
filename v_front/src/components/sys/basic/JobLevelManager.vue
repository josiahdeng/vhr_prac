<template>
  <div>
    <div>
      <el-input size="small" class="jobLevelInput" prefix-icon="el-icon-plus" v-model="jobLevel.name"></el-input>
      <el-select size="small" class="jobLevelSelect" v-model="jobLevel.titleLevel" placeholder="职称等级" clearable>
        <el-option
            v-for="item in titleLevels"
            :key="item"
            :label="item"
            :value="item"
        >
        </el-option>
      </el-select>
      <el-button type="primary" size="small" @click="addJobLevel">添加职称</el-button>
    </div>
    <div class="jobLevelMain">
      <el-table
          :data="jobLevels"
          stripe
          border
          size="small"
          style="width: 70%"
          @selection-change="selectJobLevels"
      >
        <el-table-column type="selection" width="50">
        </el-table-column>
        <el-table-column
            prop="id"
            label="编号"
            width="50"
        >
        </el-table-column>
        <el-table-column
            prop="name"
            label="职称名"
            width="120"
        >
        </el-table-column>
        <el-table-column
            prop="titleLevel"
            label="职称等级"
        >
        </el-table-column>
        <el-table-column label="创建时间" prop="createDate">
        </el-table-column>
        <el-table-column label="是否启用">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.enabled" type="success">已启用</el-tag>
            <el-tag v-else type="danger">未启用</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="200">
          <template slot-scope="scope">
            <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button size="small" type="danger" @click="delJobLevel(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-button type="danger" size="small" @click="delJobLevels" class="delIds" :disabled="selJobLevels.length === 0">
        批量删除
      </el-button>

      <el-dialog
          title="修改职称"
          :visible.sync="dialogVisible"
          width="30%">
        <div>
          <table>
            <tr>
              <td>
                <el-tag size="small">职称名</el-tag>
              </td>
              <td>
                <el-input v-model="temp.name" size="small"></el-input>
              </td>
            </tr>
            <tr>
              <td><el-tag size="small">职称等级</el-tag></td>
              <td>
                <el-select v-model="temp.titleLevel" size="small">
                  <el-option v-for="item in titleLevels" :key="item" :value="item" :label="item"></el-option>
                </el-select>
              </td>
            </tr>
            <tr>
              <td>
                <el-tag size="small">是否启用</el-tag>
              </td>
              <td>
                <el-switch v-model="temp.enabled" size="small" active-text="启用" inactive-text="禁用"></el-switch>
              </td>
            </tr>
          </table>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false" size="small">取 消</el-button>
          <el-button type="primary" size="small" @click="updateJobLevel">确 定</el-button>
        </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  name: "JobLevelManager",
  data() {
    return {
      jobLevels: [],
      jobLevel: {
        name: '',
        titleLevel: ''
      },
      titleLevels: [
        '正高级',
        '副高级',
        '中高级',
        '初高级',
        '元级'
      ],
      dialogVisible: false,
      temp: {},
      selJobLevels: []
    };
  },
  mounted() {
    this.initJobLevel();
  },
  methods: {
    initJobLevel() {
      this.getRequest('/system/basic/job_level/').then(resp => {
        if (resp && resp.status === 200) this.jobLevels = resp.obj;
      })
    },
    addJobLevel() {
      if (this.jobLevel.name && this.jobLevel.titleLevel) {
        this.postRequest('/system/basic/job_level/', this.jobLevel).then(resp => {
          if (resp && resp.status == 200) {
            this.initJobLevel();
            this.jobLevel.name = '';
            this.jobLevel.titleLevel = '';
          }
        });
      } else {
        this.$message.error("职称名称必填，职称等级必选。");
      }
    },
    delJobLevel(index, data) {
      this.$confirm(`此操作将永久删除【${data.name}】职称，是否继续？`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'waring'
      })
          .then(() => {
            this.delRequest(`/system/basic/job_level/${data.id}`).then(resp => {
              if (resp && resp.status === 200) this.initJobLevel();
            })
          })
          .catch(() => {
            this.$message.info('已取消删除')
          });
    },
    handleEdit(index, data) {
      let t= Object.assign({}, data);
      this.temp = t;
      this.dialogVisible = true;
    },
    updateJobLevel(){
      this.putRequest('/system/basic/job_level/', this.temp).then(resp => {
        if (resp && resp.status === 200) {
          this.initJobLevel();
          this.temp = {};
          this.dialogVisible = false;
        }
      })
    },
    selectJobLevels(val){
      this.selJobLevels = val
    },
    delJobLevels(){
      this.$confirm(`此操作将会永久删除【${this.selJobLevels.length}】条数据，是否继续？`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'waring'
      }).then(()  =>{
        let delJobLevelIds = [];
        this.selJobLevels.forEach(job => delJobLevelIds.push(job.id));
        this.delRequest(`/system/basic/job_level/?&ids=${delJobLevelIds.join('&ids=')}`).then(resp => {
          if (resp && resp.status === 200){
            this.initJobLevel();
          }
        })
      }).catch(() => {
        this.$message.info('已取消删除')
      })
    }
  }
}
</script>

<style>
.jobLevelInput {
  width: 300px;
  margin-top: 10px;
}

.jobLevelSelect {
  margin-left: 5px;
  margin-right: 10px;
}

.jobLevelMain {
  margin-top: 10px;
}

.delIds {
  margin-top: 10px;
}
</style>
