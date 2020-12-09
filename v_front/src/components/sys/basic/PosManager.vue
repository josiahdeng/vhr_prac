<template>
  <div>
    <div>
      <el-input
          placeholder="添加职位..."
          prefix-icon="el-icon-plus"
          v-model="position.name"
          size="small"
          class="addPosInput"
      >
      </el-input>
      <el-button icon="el-icon-plus" type="primary" size="small" @click="addPosition">
        添加
      </el-button>
    </div>
    <div class="posManMain">
      <el-table
          :data="positions"
          border
          stripe
          size="small"
          @selection-change="selectPositions"
          style="width: 70%;">
        <el-table-column type="selection" width="50">
        </el-table-column>
        <el-table-column
            prop="id"
            label="编号"
            width="55">
        </el-table-column>
        <el-table-column
            prop="name"
            label="职位名称"
            width="180">
        </el-table-column>
        <el-table-column
            prop="createDate"
            label="创建时间">
        </el-table-column>
        <el-table-column
            label="是否启用">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.enabled" type="success">已启用</el-tag>
            <el-tag v-else type="danger">未启用</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">
              编辑
            </el-button>
            <el-button size="mini" type="danger" @click="handleDel(scope.$index, scope.row)">
              删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog
          title="修改职位"
          :visible.sync="dialogVisible"
          width="30%">
        <div>
          <div>
            <el-tag>
              职位名称
            </el-tag>
            <el-input size="small" class="updatePosInput" v-model="temp.name"></el-input>
          </div>
          <div>
            <el-tag>
              是否启用
            </el-tag>
            <el-switch v-model="temp.enabled" size="small" active-text="启用" inactive-text="禁用"></el-switch>
          </div>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false" size="small">取 消</el-button>
          <el-button type="primary" @click="doUpdate" size="small">确 定</el-button>
        </span>
      </el-dialog>
    </div>
    <el-button type="danger" class="delIds" size="small" :disabled="selPositions.length === 0" @click="delPositions">批量删除</el-button>
  </div>
</template>

<script>
export default {
  name: "PosManager",
  data() {
    return {
      position: {
        name: ''
      },
      temp: {},
      positions: [],
      dialogVisible: false,
      selPositions: []
    }
  },
  mounted() {
    this.initPositions();
  },
  methods: {
    initPositions() {
      this.getRequest('/system/basic/pos/').then(resp => {
        if (resp && resp.status === 200) this.positions = resp.obj;
      });
    },
    addPosition() {
      if (this.position.name === '' || this.position.name === undefined) {
        this.$message.error("请填写职位名称");
        return;
      }
      this.postRequest('/system/basic/pos/', this.position).then(data => {
        this.position.name = ''
        this.initPositions();
      });
    },
    handleEdit(index, data) {
      this.temp = Object.assign({}, data);
      this.dialogVisible = true;
    },
    handleDel(index, data) {
      this.$confirm(`此操作将永久删除【${data.name}】职位，是否继续？`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'waring'
      })
          .then(() => {
            this.delRequest(`/system/basic/pos/${data.id}`).then(resp => {
              if (resp && resp.status === 200) this.initPositions();
            })
          })
          .catch(() => {
            this.$message.info('已取消删除')
          })
    },
    doUpdate() {
      this.putRequest(`/system/basic/pos/`, this.temp).then(resp => {
        this.initPositions();
        this.dialogVisible = false;
      })
    },
    selectPositions(val){
      this.selPositions = val;
    },
    delPositions(){
      this.$confirm(`此操作将永久删除${this.selPositions.length}条记录，是否继续？`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'waring'
      })
          .then(() => {
            let delPosIds = [];
            this.selPositions.forEach(position => {delPosIds.push(position.id)});
            this.delRequest(`/system/basic/pos/?ids=${delPosIds.join('&ids=')}`).then(resp => {
              if (resp && resp.status === 200) this.initPositions();
            });
          })
          .catch(() => {
            this.$message.info('已取消删除')
          });
    }
  }
}
</script>

<style>
.addPosInput {
  width: 300px;
  margin-right: 8px;
}

.posManMain {
  margin-top: 10px;
}

.updatePosInput {
  width: 200px;
  margin-left: 10px;
}

.delIds {
  margin-top: 10px;
}
</style>
