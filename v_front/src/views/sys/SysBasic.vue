<template>
  <div>
    <keep-alive>
      <el-tabs v-model="activeName" type="card" @tab-click="handleEvent">
        <el-tab-pane label="部门管理" name="dept"><DepManager ref="dept"></DepManager></el-tab-pane>
        <el-tab-pane label="职位管理" name="pos"><PosManager ref="pos"></PosManager></el-tab-pane>
        <el-tab-pane label="职称管理" name="job"><JobLevelManager ref="job"></JobLevelManager></el-tab-pane>
        <el-tab-pane label="奖惩机制" name="ec"><EcManager ref="ec"></EcManager></el-tab-pane>
        <el-tab-pane label="权限组" name="per"><PermissionManager ref="per"></PermissionManager></el-tab-pane>
      </el-tabs>
    </keep-alive>
  </div>
</template>

<script>
import DepManager from "@/components/sys/basic/DepManager";
import PosManager from "@/components/sys/basic/PosManager";
import JobLevelManager from "@/components/sys/basic/JobLevelManager";
import EcManager from "@/components/sys/basic/EcManager";
import PermissionManager from "@/components/sys/basic/PermissionManager";

export default {
  name: "SysBasic",
  components: {PermissionManager, EcManager, JobLevelManager, PosManager, DepManager},
  data() {
    return {
      activeName: 'dept'
    };
  },
  methods: {
    handleEvent(tab, event){
      this.$refs[tab.name].init();
    }
  },
  comments: {
    DepManager,
    PosManager,
    JobLevelManager,
    EcManager,
    PermissionManager
  }
}
</script>

<style>

</style>
