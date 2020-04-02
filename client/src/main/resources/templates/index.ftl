<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Блюда</title>
</head>
<body>

${clientIp}<br><br>

Привет, выбери блюдо которым интересуешься!

<table>
    <thead>
        <th></th>
        <th></th>
        <th></th>
    </thead>
    <tbody>

    <#list dishes as dish>
        <tr>
            <td>
            <a href="dish/${dish.id}">
                <i>${dish.name}</i></a>
            </td>

            <td>
                <a href="dish/delete/${dish.id}">удалить</a>
            </td>
            <td>
                <a href="edit-dish/${dish.id}">редактировать</a>
            </td>
        </tr>

    </#list>

    </tbody>
</table>

<br><br>

Добавить новое блюдо<br><br>


<form id="addRatingToObject" action="add-dish" method="post">

    <div>
        <label>Введите название блюда</label><br>
        <input id="name" name="name" required minlength="2">
    </div><br>

    <div>
        <label>Введите описание блюда</label><br>
        <textarea id="description" name="description" required minlength="10"></textarea>
    </div>

    <div>
        <label>Оцените блюдо</label><br>
        <input type="radio" name="rating" value="1"> 1<br>
        <input type="radio" name="rating" value="2"> 2<br>
        <input type="radio" name="rating" value="3"> 3<br>
        <input type="radio" name="rating" value="4"> 4<br>
        <input type="radio" name="rating" value="5"> 5<br>
    </div>

    <button>Отправить</button>
</form>


</body>
</html>