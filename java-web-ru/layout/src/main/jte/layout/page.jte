@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="/">Главная страница</a></li>
            <li><a href="/users">Все пользователи</a></li>
        </ul>
    </nav>
</header>
<main>
    ${content}
</main>
<footer>
    <p>&copy; 2023 My Website. Developed by <a href="https://github.com/Grand9">Grand9</a>.</p>
</footer>
</body>
</html>
