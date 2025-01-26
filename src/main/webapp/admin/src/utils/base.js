const base = {
    get() {
        return {
            url : "http://localhost:8080/ssme41wj/",
            name: "ssme41wj",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssme41wj/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SSM的学科竞赛全流程管理系统的设计与实现"
        } 
    }
}
export default base
