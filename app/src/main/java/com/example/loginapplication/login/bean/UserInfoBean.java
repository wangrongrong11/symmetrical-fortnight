package com.example.loginapplication.login.bean;

import java.util.List;

/**
 * Auth: lorry.lin
 * Date: 2020/12/15
 * Usage：
 */
        public class UserInfoBean {

        /**
         * msg : 操作成功
         * code : 200
         * permissions : []
         * roles : ["app"]
         * user : {"searchValue":null,"createBy":"admin","createTime":"2020-12-15 11:26:34","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":102,"deptId":101,"userName":"kaiyuansi","nickName":"开元寺","email":"kaiyuansi@163.com","phonenumber":"15066666666","sex":"0","avatar":"","salt":null,"status":"0","delFlag":"0","loginIp":"","loginDate":null,"dept":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"deptId":101,"parentId":100,"ancestors":null,"deptName":"无锡开元寺","orderNum":"1","leader":"若依","phone":null,"email":null,"status":"0","delFlag":null,"parentName":null,"uniCode":"test001","children":[]},"roles":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"roleId":100,"roleName":"app角色","roleKey":"app","roleSort":"3","dataScope":"1","menuCheckStrictly":false,"deptCheckStrictly":false,"status":"0","delFlag":null,"flag":false,"menuIds":null,"deptIds":null,"admin":false}],"roleIds":null,"postIds":null,"admin":false}
         */

        private String msg;
        private int code;
        private UserBean user;
        private List<?> permissions;
        private List<String> roles;

        public String getMsg() {
        return msg;
        }

        public void setMsg(String msg) {
        this.msg = msg;
        }

        public int getCode() {
        return code;
        }

        public void setCode(int code) {
        this.code = code;
        }

        public UserBean getUser() {
        return user;
        }

        public void setUser(UserBean user) {
        this.user = user;
        }

        public List<?> getPermissions() {
        return permissions;
        }

        public void setPermissions(List<?> permissions) {
        this.permissions = permissions;
        }

        public List<String> getRoles() {
        return roles;
        }

        public void setRoles(List<String> roles) {
        this.roles = roles;
        }

        public static class UserBean {
        /**
         * searchValue : null
         * createBy : admin
         * createTime : 2020-12-15 11:26:34
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * userId : 102
         * deptId : 101
         * userName : kaiyuansi
         * nickName : 开元寺
         * email : kaiyuansi@163.com
         * phonenumber : 15066666666
         * sex : 0
         * avatar :
         * salt : null
         * status : 0
         * delFlag : 0
         * loginIp :
         * loginDate : null
         * dept : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"deptId":101,"parentId":100,"ancestors":null,"deptName":"无锡开元寺","orderNum":"1","leader":"若依","phone":null,"email":null,"status":"0","delFlag":null,"parentName":null,"uniCode":"test001","children":[]}
         * roles : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"roleId":100,"roleName":"app角色","roleKey":"app","roleSort":"3","dataScope":"1","menuCheckStrictly":false,"deptCheckStrictly":false,"status":"0","delFlag":null,"flag":false,"menuIds":null,"deptIds":null,"admin":false}]
         * roleIds : null
         * postIds : null
         * admin : false
         */

        private Object searchValue;
        private String createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBean params;
        private int userId;
        private int deptId;
        private String userName;
        private String nickName;
        private String email;
        private String phonenumber;
        private String sex;
        private String avatar;
        private Object salt;
        private String status;
        private String delFlag;
        private String loginIp;
        private Object loginDate;
        private DeptBean dept;
        private Object roleIds;
        private Object postIds;
        private boolean admin;
        private List<RolesBean> roles;

        public Object getSearchValue() {
        return searchValue;
        }

        public void setSearchValue(Object searchValue) {
        this.searchValue = searchValue;
        }

        public String getCreateBy() {
        return createBy;
        }

        public void setCreateBy(String createBy) {
        this.createBy = createBy;
        }

        public String getCreateTime() {
        return createTime;
        }

        public void setCreateTime(String createTime) {
        this.createTime = createTime;
        }

        public Object getUpdateBy() {
        return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
        return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
        }

        public Object getRemark() {
        return remark;
        }

        public void setRemark(Object remark) {
        this.remark = remark;
        }

        public ParamsBean getParams() {
        return params;
        }

        public void setParams(ParamsBean params) {
        this.params = params;
        }

        public int getUserId() {
        return userId;
        }

        public void setUserId(int userId) {
        this.userId = userId;
        }

        public int getDeptId() {
        return deptId;
        }

        public void setDeptId(int deptId) {
        this.deptId = deptId;
        }

        public String getUserName() {
        return userName;
        }

        public void setUserName(String userName) {
        this.userName = userName;
        }

        public String getNickName() {
        return nickName;
        }

        public void setNickName(String nickName) {
        this.nickName = nickName;
        }

        public String getEmail() {
        return email;
        }

        public void setEmail(String email) {
        this.email = email;
        }

        public String getPhonenumber() {
        return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        }

        public String getSex() {
        return sex;
        }

        public void setSex(String sex) {
        this.sex = sex;
        }

        public String getAvatar() {
        return avatar;
        }

        public void setAvatar(String avatar) {
        this.avatar = avatar;
        }

        public Object getSalt() {
        return salt;
        }

        public void setSalt(Object salt) {
        this.salt = salt;
        }

        public String getStatus() {
        return status;
        }

        public void setStatus(String status) {
        this.status = status;
        }

        public String getDelFlag() {
        return delFlag;
        }

        public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        }

        public String getLoginIp() {
        return loginIp;
        }

        public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
        }

        public Object getLoginDate() {
        return loginDate;
        }

        public void setLoginDate(Object loginDate) {
        this.loginDate = loginDate;
        }

        public DeptBean getDept() {
        return dept;
        }

        public void setDept(DeptBean dept) {
        this.dept = dept;
        }

        public Object getRoleIds() {
        return roleIds;
        }

        public void setRoleIds(Object roleIds) {
        this.roleIds = roleIds;
        }

        public Object getPostIds() {
        return postIds;
        }

        public void setPostIds(Object postIds) {
        this.postIds = postIds;
        }

        public boolean isAdmin() {
        return admin;
        }

        public void setAdmin(boolean admin) {
        this.admin = admin;
        }

        public List<RolesBean> getRoles() {
        return roles;
        }

        public void setRoles(List<RolesBean> roles) {
        this.roles = roles;
        }

        public static class ParamsBean {
        }

        public static class DeptBean {
        /**
         * searchValue : null
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * deptId : 101
         * parentId : 100
         * ancestors : null
         * deptName : 无锡开元寺
         * orderNum : 1
         * leader : 若依
         * phone : null
         * email : null
         * status : 0
         * delFlag : null
         * parentName : null
         * uniCode : test001
         * children : []
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBeanX params;
        private int deptId;
        private int parentId;
        private Object ancestors;
        private String deptName;
        private String orderNum;
        private String leader;
        private Object phone;
        private Object email;
        private String status;
        private Object delFlag;
        private Object parentName;
        private String uniCode;
        private int tempThreshold;
        private List<?> children;

        public Object getSearchValue() {
        return searchValue;
        }

        public void setSearchValue(Object searchValue) {
        this.searchValue = searchValue;
        }

        public Object getCreateBy() {
        return createBy;
        }

        public void setCreateBy(Object createBy) {
        this.createBy = createBy;
        }

        public Object getCreateTime() {
        return createTime;
        }

        public void setCreateTime(Object createTime) {
        this.createTime = createTime;
        }

        public Object getUpdateBy() {
        return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
        return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
        }

        public Object getRemark() {
        return remark;
        }

        public void setRemark(Object remark) {
        this.remark = remark;
        }

        public ParamsBeanX getParams() {
        return params;
        }

        public void setParams(ParamsBeanX params) {
        this.params = params;
        }

        public int getDeptId() {
        return deptId;
        }

        public void setDeptId(int deptId) {
        this.deptId = deptId;
        }

        public int getParentId() {
        return parentId;
        }

        public void setParentId(int parentId) {
        this.parentId = parentId;
        }

        public Object getAncestors() {
        return ancestors;
        }

        public void setAncestors(Object ancestors) {
        this.ancestors = ancestors;
        }

        public String getDeptName() {
        return deptName;
        }

        public void setDeptName(String deptName) {
        this.deptName = deptName;
        }

        public String getOrderNum() {
        return orderNum;
        }

        public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
        }

        public String getLeader() {
        return leader;
        }

        public void setLeader(String leader) {
        this.leader = leader;
        }

        public Object getPhone() {
        return phone;
        }

        public void setPhone(Object phone) {
        this.phone = phone;
        }

        public Object getEmail() {
        return email;
        }

        public void setEmail(Object email) {
        this.email = email;
        }

        public String getStatus() {
        return status;
        }

        public void setStatus(String status) {
        this.status = status;
        }

        public Object getDelFlag() {
        return delFlag;
        }

        public void setDelFlag(Object delFlag) {
        this.delFlag = delFlag;
        }

        public Object getParentName() {
        return parentName;
        }

        public void setParentName(Object parentName) {
        this.parentName = parentName;
        }

        public String getUniCode() {
        return uniCode;
        }

        public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
        }

        public int getTempThreshold() {
        return tempThreshold;
        }

        public void setTempThreshold(int tempThreshold) {
        this.tempThreshold = tempThreshold;
        }

        public List<?> getChildren() {
        return children;
        }

        public void setChildren(List<?> children) {
        this.children = children;
        }

        public static class ParamsBeanX {
        }
        }

        public static class RolesBean {
        /**
         * searchValue : null
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * roleId : 100
         * roleName : app角色
         * roleKey : app
         * roleSort : 3
         * dataScope : 1
         * menuCheckStrictly : false
         * deptCheckStrictly : false
         * status : 0
         * delFlag : null
         * flag : false
         * menuIds : null
         * deptIds : null
         * admin : false
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBeanXX params;
        private int roleId;
        private String roleName;
        private String roleKey;
        private String roleSort;
        private String dataScope;
        private boolean menuCheckStrictly;
        private boolean deptCheckStrictly;
        private String status;
        private Object delFlag;
        private boolean flag;
        private Object menuIds;
        private Object deptIds;
        private boolean admin;

        public Object getSearchValue() {
        return searchValue;
        }

        public void setSearchValue(Object searchValue) {
        this.searchValue = searchValue;
        }

        public Object getCreateBy() {
        return createBy;
        }

        public void setCreateBy(Object createBy) {
        this.createBy = createBy;
        }

        public Object getCreateTime() {
        return createTime;
        }

        public void setCreateTime(Object createTime) {
        this.createTime = createTime;
        }

        public Object getUpdateBy() {
        return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
        return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
        }

        public Object getRemark() {
        return remark;
        }

        public void setRemark(Object remark) {
        this.remark = remark;
        }

        public ParamsBeanXX getParams() {
        return params;
        }

        public void setParams(ParamsBeanXX params) {
        this.params = params;
        }

        public int getRoleId() {
        return roleId;
        }

        public void setRoleId(int roleId) {
        this.roleId = roleId;
        }

        public String getRoleName() {
        return roleName;
        }

        public void setRoleName(String roleName) {
        this.roleName = roleName;
        }

        public String getRoleKey() {
        return roleKey;
        }

        public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
        }

        public String getRoleSort() {
        return roleSort;
        }

        public void setRoleSort(String roleSort) {
        this.roleSort = roleSort;
        }

        public String getDataScope() {
        return dataScope;
        }

        public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
        }

        public boolean isMenuCheckStrictly() {
        return menuCheckStrictly;
        }

        public void setMenuCheckStrictly(boolean menuCheckStrictly) {
        this.menuCheckStrictly = menuCheckStrictly;
        }

        public boolean isDeptCheckStrictly() {
        return deptCheckStrictly;
        }

        public void setDeptCheckStrictly(boolean deptCheckStrictly) {
        this.deptCheckStrictly = deptCheckStrictly;
        }

        public String getStatus() {
        return status;
        }

        public void setStatus(String status) {
        this.status = status;
        }

        public Object getDelFlag() {
        return delFlag;
        }

        public void setDelFlag(Object delFlag) {
        this.delFlag = delFlag;
        }

        public boolean isFlag() {
        return flag;
        }

        public void setFlag(boolean flag) {
        this.flag = flag;
        }

        public Object getMenuIds() {
        return menuIds;
        }

        public void setMenuIds(Object menuIds) {
        this.menuIds = menuIds;
        }

        public Object getDeptIds() {
        return deptIds;
        }

        public void setDeptIds(Object deptIds) {
        this.deptIds = deptIds;
        }

        public boolean isAdmin() {
        return admin;
        }

        public void setAdmin(boolean admin) {
        this.admin = admin;
        }

        public static class ParamsBeanXX {
        }
        }
        }
        }
