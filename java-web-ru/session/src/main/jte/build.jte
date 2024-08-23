@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
content = @`
    @if(page.getError() != null)
        <div>
            ${page.getError()}
        </div>
    @endif

    <form action="${NamedRoutes.buildSessionPath()}" method="post">
        <label>
            Имя
            <input type="text" placeholder="Имя" name="name" value="${page.getName()}">
        </label>
        <label>
            Пароль
            <input type="password" placeholder="Пароль" name="password" />
        </label>
        <label>
            Войти
            <input type="submit" />
        </label>
    </form>
`
)