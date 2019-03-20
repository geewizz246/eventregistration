<template>
    <div id="eventregistration">
        <h2>People</h2>
        <table>
            <tr v-for="person in people" v-bind:key="person.name" >
                <td>{{ person.name }}</td>
                <td>
                    <ul>
                    <li v-for="event in person.events" v-bind:key="event.name">
                        {{event.name}}
                    </li>
                    </ul>
                </td>
            </tr>
            <tr>
            <td>
                <input type="text" v-model="newPerson" placeholder="Person Name">
            </td>
            <td>
                <button @click="createPerson(newPerson)">Create Person</button>
            </td>
            </tr>
        </table>
        <p>
            <span v-if="errorPerson" style="color:red">Error: {{errorPerson}} </span>
        </p>
    </div>
</template>
<script src="./registration.js">
</script>
<style>
    #eventregistration {
        font-family: 'Avenir', Helvitica, Arial, sans-serif;
        color: #2c3e50;
        background: #f2ece8;
    }
</style>