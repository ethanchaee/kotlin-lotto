package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoPrizeStatics
import lotto.domain.Prize

object ResultView {

    fun showLottos(lottos: List<Lotto>) {
        println("${lottos.size} 개를 구매했습니다.")
        lottos.forEach { println(it.toString()) }
    }

    fun showPrizeStatics(prizeStatics: LottoPrizeStatics) {
        val showPrizeStaticsString = StringBuilder(
            """당첨 통계---------
            |
            |
        """.trimMargin()
        )
        Prize.values().filter { it.prizeMoney > 0 }.forEach {
            showPrizeStaticsString.append("${it.countOfMatch} 개 일치 ( ${it.count} 개 일치 ( ${it.prizeMoney}")
                .append(
                    """원) -${it.count} 개
                |
            """.trimMargin()
                )
        }
        showPrizeStaticsString.append("총 수익률은 ${prizeStatics.profitRate} 입니다.")
        if (prizeStatics.profitRate < 1) showPrizeStaticsString.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        println(showPrizeStaticsString)
    }
}
