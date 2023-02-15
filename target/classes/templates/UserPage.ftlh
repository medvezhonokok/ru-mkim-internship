<#-- @ftlvariable name="isUser.name" type="java.lang.String" -->
<#import "/spring.ftl" as spring>
<#import "common.ftlh" as c>

<@c.page>
    <#if isUser??>
        <h1>Handle: </h1> ${isUser.login}
        <h1>On TaskManagerImpl since: </h1> ${isUser.creationTime}
    <#else>
        No such user
    </#if>
</@c.page>

