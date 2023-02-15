<#import "/spring.ftl" as spring>
<#import "common.ftlh" as c>

<@c.page>
    <#if user??>
        <div class="task-add-form-box">
            <div class="header">
                <div class="add-task">
                    Add task
                </div>
            </div>
            <div class="body">
                <form method="post" action="">
                    <div class="field">
                        <div class="name">
                            <label for="title">Title</label>
                        </div>
                        <div class="value">
                            <input id="title" name="title" value="${addForm.title!}"/>
                        </div>
                        <@c.error "addForm.title"/>
                    </div>
                    <div class="field">
                        <div class="name">
                            <label for="text">Text</label>
                        </div>
                        <div class="value">
                            <textarea id="text" name="text" type="text"></textarea>
                        </div>
                        <@c.error "addForm.text"/>
                    </div>
                    <div class="button-field">
                        <input type="submit" value="Add task">
                    </div>
                </form>
            </div>
        </div>
    <#else>
        Please, verify yourself.
    </#if>
</@c.page>

