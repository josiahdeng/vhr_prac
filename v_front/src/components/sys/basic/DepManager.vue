<template>
  <div>
    <div>
      <el-input
          style="width: 500px;"
          placeholder="请输入部门名称进行搜索"
          v-model="filterText" size="small" prefix-icon="el-icon-search">
      </el-input>

      <el-tree
          class="filter-tree"
          :data="depts"
          :props="defaultProps"
          :filter-node-method="filterNode"
          style="width: 500px;"
          :expand-on-click-node="false"
          ref="tree">
        <span class="custom-tree-node" style="display: flex; justify-content: space-between;width: 100%;" slot-scope="{ node, data }">
        <span>{{ node.label }}</span>
        <span>
          <el-button
              type="primary"
              size="mini"
              class="depButton"
              @click="() => showDept(data)">
            添加部门
          </el-button>
          <el-button
              type="danger"
              size="mini"
              class="depButton"
              @click="() => removeDept(data)">
            删除部门
          </el-button>
        </span>
      </span>
      </el-tree>
      <el-dialog
          title="添加部门"
          :visible.sync="dialogVisible"
          width="30%">
        <span>
          <div>
            <table>
              <tr>
                <td>
                  <el-tag size="small">上级部门</el-tag>
                </td>
                <td>
                  <span>{{pName}}</span>
                </td>
              </tr>
              <tr>
                <td>
                  <el-tag size="small">部门名称</el-tag>
                </td>
                <td>
                  <el-input v-model="dept.name" placeholder="请输入部门名称" size="small"></el-input>
                </td>
              </tr>
            </table>
          </div>
        </span>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false" size="small">取 消</el-button>
    <el-button type="primary" @click="addDept" size="small">确 定</el-button>
  </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  name: "DepManager",
  watch: {
    filterText(val) {
      this.$refs.tree.filter(val);
    }
  },
  data() {
    return {
      filterText: '',
      depts: [],
      defaultProps: {
        children: 'children',
        label: 'name'
      },
      dialogVisible: false,
      dept: {
        name: '',
        parentId: ''
      },
      pName: ''
    }
  },
  mounted() {
    this.initDept();
  },
  methods: {
    filterNode(value, data) {
      if (!value) return true;
      return data.name.indexOf(value) !== -1;
    },
    initDept(){
      this.getRequest('/system/basic/dept/').then(resp => {
        if(resp && resp.status) this.depts = resp.obj;
      })
    },
    showDept(data){
      this.pName = data.name;
      this.dept.parentId = data.id;
      this.dialogVisible = true;
    },
    addDept(){
      this.postRequest('/system/basic/dept/', this.dept).then(resp => {
        if (resp && resp.status === 200){
          this.addDept2Depts(this.depts, resp.obj);
          this.dept.name = ''
          this.dept.parentId = ''
          this.pName = ''
          this.dialogVisible = false;
        }
      });
    },
    addDept2Depts(depts, dept){
      for (const de of depts) {
        if (de.id === dept.parentId){
          de.children = de.children.concat(dept);
          de.isParent = true;
          return ;
        } else {
          this.addDept2Depts(de.children, dept);
        }
      }
    },
    removeDept(data){
      if (data.isParent){
        this.$message.error("父部门不可删除！");
        return;
      }
      this.$confirm(`是否删除【${data.name}】?`, '提示', {
        type: "warning",
        confirmButtonText: '确认',
        cancelButtonText: '取消'
      }).then(() => {
        this.delRequest(`/system/basic/dept/${data.id}`).then(resp => {
          if (resp && resp.status === 200){
            this.removeDept2Depts(this.depts, data);
          }
        })
      }).catch(() => {
        this.$message.info("您取消了该操作。");
      })
    },
    removeDept2Depts(depts, dept, parent){
      for (let i = 0; i < depts.length; i++) {
        if (depts[i].id === dept.id){
          depts.splice(i, 1);
          if (depts.length === 0) parent.isParent = false;
          return;
        } else {
          this.removeDept2Depts(depts[i].children, dept, depts[i]);
        }
      }
    }
  }
}
</script>

<style>
.depButton {
  padding: 2px;
}
</style>
