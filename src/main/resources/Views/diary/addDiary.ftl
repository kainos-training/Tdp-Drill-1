<#import "../layout.ftl" as layoutTemplate>
<@layoutTemplate.layout>

<a href="/project">Project</a>

<div class="container panel-box">
<h1>Add new diary entry</h1>
<p class="lead">Please ensure accurate information is provided below before attempting to add this new diary entry.</p>
​
<form enctype="multipart/form-data" action="#" method="post" autocomplete="off">

    <#if errors??>
        <div class="bg-danger text-danger">
            <ul>
            <#list errors as error>
                <li>
                    ${error}
                </li>
            </#list>
            </ul>
        </div>
    </#if>

    <div class="form-group">
        <label for="title">Title</label>
        <input name="title" id="title" type="text" placeholder="Title" class="form-control" required />
    </div>
    ​
    <div class="form-group">
        <label for="category">Category</label> <br/>
        <select id="category" class="form-control" required>
            <option class="form-control" value="" disabled selected>Select a catergory...</option>
            <option class="form-control" value="vision">Vision</option>
            <option class="form-control" value="goals">Goals</option>
            <option class="form-control" value="mercedes">User story creation</option>
            <option class="form-control" value="nfrs">NFRs</option>
            <option class="form-control" value="other">Other</option>
        </select>
    </div>
    ​
    <div class="form-group">
        <label for="date">Date</label>
        <input name="date" id="date" type="text" placeholder="dd//mm//yyyy" class="form-control" required />
    </div>
    ​
    ​
    <div class="form-group">
        <label for="startTime">Start time</label>
        <input name="startTime" id="startTime" type="text" placeholder="08:00 - 24hr clock" class="form-control" required />
    </div>
    ​
    <div class="form-group">
        <label for="endTime">End time</label>
        <input name="endTime" id="endTime" type="text" placeholder="08:00 - 24hr clock" class="form-control" required />
    </div>
    ​
    <div class="form-group">
        <label for="sessionGoal">Session goal</label>
        <textarea name="sessionGoal" id="sessionGoal" placeholder="Enter text here..." class="form-control" required></textarea>
    </div>
    ​
    ​
    <input type="submit" value="Save diary entry" class="btn btn-primary" />
    <a class="btn btn-default" href="#">Cancel</a>
    ​
</form>
</div>

</@layoutTemplate.layout>
