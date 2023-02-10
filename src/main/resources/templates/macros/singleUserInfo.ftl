<#macro singleUserInfo user>
    <h3> id: ${user.id}</h3>
    <h3> firstName: ${user.firstName}</h3>
    <h3> lastName: ${(user.lastName)!"default text"}</h3>
    <h3> age: ${user.age}</h3>
    <h3> login: ${user.login}</h3>
    <h3> password: ${user.password}</h3>
</#macro>