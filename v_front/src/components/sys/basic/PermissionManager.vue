<template>
  <div>
    <div class="perMainInput">
      <el-input placeholder="请输入角色英文名" size="small" class="perEn" v-model="role.name">
        <template slot="prepend">ROLE_</template>
      </el-input>

      <el-input placeholder="请输入角色名" size="small" class="perZh" v-model="role.nameZh">
      </el-input>

      <el-button size="small" type="primary" icon="el-icon-plus" @click="addRole">
        添加角色
      </el-button>
    </div>
    <div class="dataContent">
      <el-collapse v-model="activeName" accordion @change="change">
        <el-collapse-item :title="role.nameZh" :name="role.id" v-for="(role, index) in roles" :key="index">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>可访问的资源</span>
              <el-button style="float: right; padding: 3px 0;color: red;" type="text" icon="el-icon-delete" @click="deleteRole(role)" :key="index"/>
            </div>
            <div>
              <el-tree :data="allMenus" :key="index" :props="menuProps" ref="tree" show-checkbox node-key="id" :default-checked-keys="selectedMenus"></el-tree>
              <div style="display: flex;justify-content: flex-end;">
                <el-button size="mini">取消修改</el-button>
                <el-button size="mini" type="primary" @click="doMenuRoleUpdate(role.id, index)">确认修改</el-button>
              </div>
            </div>
          </el-card>
        </el-collapse-item>
      </el-collapse>
    </div>
  </div>
</template>

<script>
export default {
  name: "PermissionManager",
  data() {
    return {
      role: {
        name: '',
        nameZh: ''
      },
      roles: [],
      allMenus: [],
      menuProps: {
        children: 'children',
        label: 'name'
      },
      selectedMenus: [],
      activeName: -1
    }
  },
  methods: {
    init() {
      this.getRequest('/system/basic/permission/').then(resp => {
        if (resp && resp.status === 200) this.roles = resp.obj;
      });
    },
    initAllMenus(){
      this.getRequest("/system/basic/permission/menus").then(resp => {
        if (resp && resp.status === 200) this.allMenus = resp.obj;
      });
    },
    initSelectedMenus(r_id){
      this.getRequest(`/system/basic/permission/mids/${r_id}`).then(resp => {
        if (resp && resp.status === 200) this.selectedMenus = resp.obj;
      })
    },
    change(value){
      if(value) {
       this.initAllMenus();
       this.initSelectedMenus(value);
      } else {
        this.selectedMenus = [];
      }
    },
    doMenuRoleUpdate(r_id, index){
      let tree = this.$refs.tree[index];
      let checkedKeys = tree.getCheckedKeys(true);

      let requestUrl = `/system/basic/permission/mids?rId=${r_id}`;
      checkedKeys.forEach(key => {
        requestUrl += `&mIds=${key}`;
      });
      this.putRequest(requestUrl).then(resp => {
        if (resp && resp.status === 200) {
          this.activeName = -1;
        }
      });
    },
    addRole(){
      if (!this.role.name || !this.role.nameZh){
        this.$message.error("角色英文名、角色中文名必填！！");
        return;
      }
      this.postRequest("/system/basic/permission/role", this.role).then(resp => {
        if(resp && resp.status === 200){
          this.init();
          this.role.name = '';
          this.role.nameZh = "";
        }
      });
    },
    deleteRole(role){
      this.$confirm(`此操作将永久删除【${role.nameZh}】,是否继续操作？`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'waring'
      }).then(() => {
        this.delRequest(`/system/basic/permission/role/${role.id}`).then(resp => {
          if (resp && resp.status === 200) this.init();
        })
      }).catch(() => {
        this.$message.info("已取消该操作！");
      })
    }
  }
}
</script>

<style>
.perMainInput {
  display: flex;
  justify-content: flex-start;
}

.perMainInput .el-input {
  width: 300px;
  margin-right: 10px;
}

.dataContent {
  margin-top: 10px;
  width: 800px;
}
</style>
