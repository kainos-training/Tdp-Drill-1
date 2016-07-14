<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

 <div class="well">
      <h1>${project.name}</h1>

      <hr>

      <h2>Description</h2>
      <p>${project.description}</p>
      </div>

</@layoutTemplate.layout>