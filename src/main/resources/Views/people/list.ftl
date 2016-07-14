<#-- @ftlvariable name="" type="com.kainos.discoverydiary.views.PeopleListView" -->
<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

<h1>People list</h1>
<p class="lead">Registered people.</p>

<table class="table">
    <thead>
        <th>Name</th>
        <th>Age</th>
        <th></th>
    </thead>

    <tbody>
        <#list people as person>
            <tr>
            <td>
                ${person.name}
            </td>
            <td>
                ${person.age}
            </td>
            <td>
                <img src="/profilePics/${person.profilePictureName}" style="max-width: 200px; max-height: 200px" />
            </td>
            </tr>
        </#list>

    </tbody>
</table>

<a class="btn btn-default" href="/people/add">New</a>

</@layoutTemplate.layout>