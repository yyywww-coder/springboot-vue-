export default {
    name: "User",
    data() {
        return {
            searchText: '',
            pageSize: 4,
            pageIndex: 1,
            totalCount: 0,
            userData: [
                { id: '', account: '', status: '' }
            ],
        }
    },
    methods: {
        changeCurrentPage(currPage) {
            this.pageIndex = currPage
            this.getUser(this.searchText, this.pageIndex)
        },
        //条件搜索用户
        //条件查找
        startQuery() {
            this.pageIndex = 1;
            this.getUser(this.searchText, this.pageIndex)

        },
        //修改用户状态
        changeStatus(row) {
            if (row.status == "1") {
                row.status = "2"
            } else {
                row.status = "1"
            }
            this.$axios.get("/user/update", {
                params: {
                    id: row.id,
                    status: row.status
                }
            }).then(res => {
                //alert(res.config)
                console.log(res);
                //alert(res);
                if (res.data.code == 200) {
                    this.$message({ type: 'success', message: "修改成功", duration: 800 });
                    //重新加载页面
                    this.getUser()
                } else if (res.data.code == 403) {
                    this.$message({ type: 'warning', message: "没有该权限", duration: 800 });
                }
            })
        },
        //获取用户列表,带分页
        getUser(searchText = '', pageIndex = 1) {
            this.searchText = searchText;
            this.pageIndex = pageIndex;
            this.$axios.get("/user/list", {
                params: { "pageIndex": this.pageIndex, "pageSize": this.pageSize, "searchName": this.searchText, "status": this.value }
            }).then(res => {
                console.log(res)
                this.userData = res.data.data.list;
                this.totalCount = res.data.data.total
                this.pageIndex = res.data.data.pageNum
            })
        }
    },
    watch: {

    },
    created() {
        this.getUser()
    }
}