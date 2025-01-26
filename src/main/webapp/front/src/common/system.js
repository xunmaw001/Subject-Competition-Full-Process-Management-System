export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除"],"menu":"教师","menuJump":"列表","tableName":"jiaoshi"}],"menu":"教师管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除","查看评论"],"menu":"竞赛信息","menuJump":"列表","tableName":"jingsaixinxi"}],"menu":"竞赛信息管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改","删除","审核"],"menu":"竞赛报名","menuJump":"列表","tableName":"jingsaibaoming"}],"menu":"竞赛报名管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除","竞赛成绩分析"],"menu":"竞赛成绩","menuJump":"列表","tableName":"jingsaichengji"}],"menu":"竞赛成绩管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除","查看评论"],"menu":"获奖展示","menuJump":"列表","tableName":"huojiangzhanshi"}],"menu":"获奖展示管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["新增","查看","修改","删除"],"menu":"规则通知","menuJump":"列表","tableName":"guizetongzhi"}],"menu":"规则通知管理"},{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["新增","查看","修改","删除","竞赛经费分析"],"menu":"竞赛经费","menuJump":"列表","tableName":"jingsaijingfei"}],"menu":"竞赛经费管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["新增","查看","修改","删除"],"menu":"模拟训练管理","tableName":"exampaper"}],"menu":"模拟训练管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"试题管理","tableName":"examquestion"}],"menu":"试题管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["新增","查看","修改","删除"],"menu":"管理员","tableName":"users"}],"menu":"管理员管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除"],"menu":"错题本","tableName":"examfailrecord"},{"appFrontIcon":"cuIcon-baby","buttons":["新增","查看","修改","删除"],"menu":"模拟训练列表","tableName":"exampaperlist"},{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","修改","删除"],"menu":"考试记录","tableName":"examrecord"}],"menu":"考试管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","报名"],"menu":"竞赛信息列表","menuJump":"列表","tableName":"jingsaixinxi"}],"menu":"竞赛信息模块"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"规则通知列表","menuJump":"列表","tableName":"guizetongzhi"}],"menu":"规则通知模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除","竞赛成绩分析"],"menu":"竞赛成绩","menuJump":"列表","tableName":"jingsaichengji"}],"menu":"竞赛成绩管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["新增","查看","修改","删除"],"menu":"规则通知","menuJump":"列表","tableName":"guizetongzhi"}],"menu":"规则通知管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["新增","查看","修改","删除"],"menu":"模拟训练管理","tableName":"exampaper"}],"menu":"模拟训练管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"试题管理","tableName":"examquestion"}],"menu":"试题管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","修改","删除"],"menu":"考试记录","tableName":"examrecord"},{"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除"],"menu":"错题本","tableName":"examfailrecord"},{"appFrontIcon":"cuIcon-baby","buttons":["新增","查看","修改","删除"],"menu":"模拟训练列表","tableName":"exampaperlist"}],"menu":"考试管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","报名"],"menu":"竞赛信息列表","menuJump":"列表","tableName":"jingsaixinxi"}],"menu":"竞赛信息模块"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"规则通知列表","menuJump":"列表","tableName":"guizetongzhi"}],"menu":"规则通知模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"否","roleName":"教师","tableName":"jiaoshi"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"竞赛报名","menuJump":"列表","tableName":"jingsaibaoming"}],"menu":"竞赛报名管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看"],"menu":"竞赛成绩","menuJump":"列表","tableName":"jingsaichengji"}],"menu":"竞赛成绩管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","报名"],"menu":"竞赛信息列表","menuJump":"列表","tableName":"jingsaixinxi"}],"menu":"竞赛信息模块"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"规则通知列表","menuJump":"列表","tableName":"guizetongzhi"}],"menu":"规则通知模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"学生","tableName":"xuesheng"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
