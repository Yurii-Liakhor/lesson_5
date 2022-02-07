<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>

<h1>List of cars</h1>
${cars}

<br/>

<h2>To add new car press "Add car" button</h2>
<form method="POST" action="/lesson_4_war_exploded/car/add">
    <table>
        <tr>
            <td><label for="manufacturer">Manufacturer:</label></td>
            <td><input type="text" name="manufacturer" id="manufacturer"/></td>
        </tr>
        <tr>
            <td><label for="model">Model:</label></td>
            <td><input type="text" name="model" id="model"/></td>
        </tr>
        <tr>
            <td><label for="engineCapacity">Engine capacity:</label></td>
            <td><input type="text" name="engineCapacity" id="engineCapacity"/></td>
        </tr>
        <tr>
            <td><label for="maxSpeed">Max speed:</label></td>
            <td><input type="text" name="maxSpeed" id="maxSpeed"/></td>
        </tr>
        <tr>
            <td><label for="price">Price:</label></td>
            <td><input type="text" name="price" id="price"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Add Car">
            </td>
        </tr>
    </table>
</form>

<br/><br/>
<form method="POST" action="/lesson_4_war_exploded/car/findByManufacturer">
    <table>
        <tr>
            <td><label for="manufacturer">Manufacturer</label></td>
            <td><input type="text" name="manufacturer"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Search by manufacturer">
            </td>
        </tr>
    </table>
</form>

<br/><br/>
<form method="POST" action="/lesson_4_war_exploded/car/findByManufacturerAndModelAndMaxSpeed">
    <table>
        <tr>
            <td><label for="manufacturer">Manufacturer</label></td>
            <td><input type="text" name="manufacturer"/></td>
        </tr>
        <tr>
            <td><label for="model">Model</label></td>
            <td><input type="text" name="model"/></td>
        </tr>
        <tr>
            <td><label for="maxSpeed">MaxSpeed</label></td>
            <td><input type="text" name="maxSpeed"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Search by manufacturer, model and max speed">
            </td>
        </tr>
    </table>
</form>

<br/><br/>
<form method="POST" action="/lesson_4_war_exploded/car/removeById">
    <table>
        <tr>
            <td><label for="id">Id</label></td>
            <td><input type="text" name="id"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="remove car by id">
            </td>
        </tr>
    </table>
</form>

<br/><br/>
<form method="GET" action="/lesson_4_war_exploded/car/removeByManufacturer">
    <input type="hidden" name="manufacturer" value="Audi" />
    <input type="submit" value="remove cars by Tesla manufacturer">
</form>

</body>
</html>

