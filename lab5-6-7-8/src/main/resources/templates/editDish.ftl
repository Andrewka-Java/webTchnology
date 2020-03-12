<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Блюда</title>
</head>
<body>

Привет, редактируйте описание блюда!

<form id="addRatingToObject" action="/update-dish/${updateDish.id}" method="post">

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

    <button>Обновить</button>
</form>


</body>
</html>