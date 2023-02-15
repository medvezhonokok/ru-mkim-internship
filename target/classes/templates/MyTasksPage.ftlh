<#import "/spring.ftl" as spring>
<#import "common.ftlh" as c>

<@c.page>
    <#if user??>
        <#if myTasks??>
            <#list myTasks as myTask>
                <@c.show myTask></@c.show>
            </#list>
        <#else>
            You have hot no tasks.
        </#if>
    </#if>
</@c.page>

