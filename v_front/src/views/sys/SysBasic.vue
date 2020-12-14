<template>
  <div>
      <el-tabs v-model="activeName" type="card" @tab-click="handleEvent">
        <el-tab-pane label="部门管理" name="first"><DepManager></DepManager></el-tab-pane>
        <el-tab-pane label="职位管理" name="second"><PosManager></PosManager></el-tab-pane>
        <el-tab-pane label="职称管理" name="third"><JobLevelManager></JobLevelManager></el-tab-pane>
        <el-tab-pane label="奖惩机制" name="fourth"><EcManager></EcManager></el-tab-pane>
        <el-tab-pane label="权限组" name="fifth"><PermissionManager></PermissionManager></el-tab-pane>
      </el-tabs>
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
      activeName: 'first'
    };
  },
  methods: {
    handleEvent(tab, event){
      console.log(tab, event);
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
