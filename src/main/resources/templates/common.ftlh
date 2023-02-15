<#-- @ftlvariable name="user.login" type="java.lang.String" -->
<#-- @ftlvariable name="author" type="java.lang.String" -->
<#import "/spring.ftl" as spring>

<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>TaskManagerImpl</title>
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/normalize.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/form.css'/>">
        <script src="<@spring.url '/js/jquery-3.6.1.min.js'/>"></script>
        <script src="<@spring.url '/js/notify.min.js'/>"></script>
        <script src="<@spring.url '/js/app.js'/>"></script>
    </head>
    <body class="body">

    <div class="header">
        <div class="logo">
            <img src="<@spring.url '/img/codeforces-sponsored-by-ton.png'/>" alt="Logo" title="TaskManagerImpl"/>
        </div>
        <div class="enter-register-box">
            <#if user??>
                ${user.login}
                |
                <a id="logoutButton" href="<@spring.url '/logout'/>">LOGOUT</a>
            <#else>
                <a id="enterButton" href="<@spring.url '/enter'/>">ENTER</a>
                |
                <a id="registerButton" href="<@spring.url '/register'/>">REGISTER</a>
            </#if>
        </div>
    </div>

    <div class="nav-bar">
        <ul>
            <li>
                <a href="<@spring.url '/index'/>">HOME</a>
            </li>
            <li>
                <a href="<@spring.url '/add_task'/>">ADD TASK</a>
            </li>
            <li>
                <a href="<@spring.url '/my_tasks'/>">MY TASKS</a>
            </li>
            <li>
                <a href="<@spring.url '/tasks_all'/>">ALL TASKS</a>
            </li>
        </ul>
    </div>

    <div class="middle-part">
        <#nested/>
    </div>

    <div class="footer">
        &copy; medvezhonokok
    </div>
    <script>
        $(function () {
            <#if message??>
            notify("${message?js_string}");
            </#if>
        })
    </script>
    </body>
    </html>

</#macro>

<#macro error field>
    <@spring.bind field/>
    <#if spring.status.errorMessage??>
        <div class="error">${spring.status.errorMessage}</div>
    </#if>
</#macro>

<#macro getUseById userId>

</#macro>

<#macro show task>
<#-- @ftlvariable name="task" type="ru.internship.model.Task" -->
    <div class="task-show">
        <div class="header">
            <div class="header-task">
                Title: ${task.title}
            </div>
        </div>
        <p>
            ${task.text}
        </p>
        <div class="by">
            by: <a href="/users_${task.userId}">author</a> ${task.creationTime},
        </div>
    </div>
</#macro>
