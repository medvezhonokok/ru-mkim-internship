<#import "/spring.ftl" as spring>
<#import "common.ftlh" as c>

<@c.page>
    <#if tasks??>
        <#list tasks as t>
            <@c.show t></@c.show>
        </#list>
    <#else>
        No such tasks.
    </#if>
</@c.page>

