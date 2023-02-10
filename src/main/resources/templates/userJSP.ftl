<#import "macros/common.ftl" as com>
<#import "macros/singleUserInfo.ftl" as sui>

<@com.common "User page">
<h2>This is user:</h2>
<@sui.singleUserInfo user/>
</@com.common>