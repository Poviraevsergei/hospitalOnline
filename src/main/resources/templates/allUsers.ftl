<#import "macros/common.ftl" as com>
<#import "macros/singleUserInfo.ftl" as sui>

<@com.common "All users FTL">
    <#list users as user>
        <@sui.singleUserInfo user/>
        <h4> -------------------------</h4>
    </#list>
</@com.common>