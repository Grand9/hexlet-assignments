@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    !{var name = page.getName();}

    @if(name == null)
        <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
    @endif

    @if(name != null)
        <div>
            <h2>${name.toString()}</h2>
        </div>

        <form action="${NamedRoutes.logoutPath()}" method="post">
            <label>
                Выйти
                <input type="submit" />
            </label>
        </form>
    @endif
`
)