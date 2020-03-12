<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Борщ</title>
</head>
<body>

Привет, выбери блюдо которым интересуешься!

<ul>
    <li><a href="/borsh"><i>Борщ</i></a></li>
    <li><a href="/draniki"><i>Драники</i></a></li>
    <li><a href="/pelmeni"><i>Пельмени</i></a></li>
</ul>

Есть предложения по новым блюдам? Тогда действуй!<br>
Выберерите формат отправки GET или POST.<br>

___________________________________________________________________________________
GET
<form id="sendNewDish" action="/add-dish-get" method="get">
    <div>
        <label>Введите название блюда</label><br>
        <input id="name" name="name" required minlength="2">
    </div><br>

    <div>
        <textarea id="description" name="description" required="10"></textarea>
    </div>

    <button>Отправить</button>
</form><br>

____________________________________________________________________________________
POST
<form id="addRatingToObject" action="/add-dish-post" method="post">

    <div>
        <label>Введите название блюда</label><br>
        <input id="name" name="name" required minlength="2">
    </div><br>

    <div>
        <textarea id="description" name="description" required="10"></textarea>
    </div>


    <input type="radio" name="rating" value="1"> 1<br>
    <input type="radio" name="rating" value="2"> 2<br>
    <input type="radio" name="rating" value="3"> 3<br>
    <input type="radio" name="rating" value="4"> 4<br>
    <input type="radio" name="rating" value="5"> 5<br>
    <button>Отправить</button>
</form>


</body>
</html>