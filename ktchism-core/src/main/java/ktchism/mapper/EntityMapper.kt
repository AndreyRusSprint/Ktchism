package ktchism.mapper

interface EntityMapper<in FROM, out TO> {
    fun transform(from: FROM): TO
}
