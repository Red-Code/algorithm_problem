package pers.cly.algorithm.birthday_paradox;

/**
 * Created by CLY on 2017/4/12.
 */

/**
 * 问题：
 * 一个屋子里人数必须要达到多少人，才能使其中两人生日相同的机会达到50%？
 */
public class Main {
    /**
     * 设：
     * 1、设k是屋子里的总人数，对每一个人进行编号，则编号为1,2,3···k。
     * 2、设所有年份都是365天，n=365
     * 3、bi表示第i个人的生日天数，所以1<=bi<=360，1<=i<=k
     */

    /**
     * 第i个人的生日正好在“第r天的概率”为：
     *
     * P{bi=r} = 1/n
     */

    /**
     * 第i个人和第j个人的生日，“都落在第r天的概率”为：
     *
     * P{bi=r且bj=r} = P{bi=r}*P{bj=r} = (1/n)^2
     */

    /**
     * 第i个人和第j个人的生日，“都落在同一天的概率”为？
     * 此处的落在同一天并没有指定落在那一天，所以可以都是第1天或者都是第二天或者·····
     *
     * P{bi=bj}
     * = P{bi=1}*P{bj=1} + P{bi=2}*P{bj=2}+···+P{bi=n}*P{bj=n}
     * = (1/n)^2 + (1/n)^2 + ···+ (1/n)^2
     * = 1/n
     */

    /**
     * 原问题是：找到“至少有两个人生日相等”
     * 换句话说就是：1减去所有人生日都互不相同的概率。
     * 所以接下来就要找到“所有人生日都互不相同的概率”
     *
     * 设：
     * 1、有k个人，这k个人生日都互不相同的事件为：Bk
     * 2、那么k个人生日都互不相同的事件的概率就为：P{Bk}
     * 3、有一个人i，有多个人1-j，其中j<i（也就是说那多个人的编号从1到j，且j编号还小于i编号）
     *      则这个第i个人和1-j个人的生日不相同的事件为：Ai
     *      （即：i与1的生日不同，且i与2的生日不同···且i与j的生日不同。
     *       注意：此处1-j个人之间生日是否不同并没有做强制规定）
     * 4、这个第i个人和1-j个人的生日不相同的事件的概率为P{Ai}
     *
     * 由此我们就可推出：
     * Bk = A1 * A2 * A3 *···* Ak
     * 因为：
     * Bk指的是k个人中，“两两”生日不等的事件。
     * A1指的是，1个人时，“两两”生日不等的事件。
     * A2指的是，第2个人和第1个人生日不等的事件。
     * A3指的是，第3个人和第1个人生日不等、且第3个人和第2个人生日不等。
     * A4指的是，第4个人和第1个人生日不等、且第4个人和第2个人生日不等。第4个人和第3个人生日不等。
     * ·····
     * 所以A1到Ak所有事件都发生的情况下，就是Bk这个事件。
     *
     * 转换成概率就是：
     * P{Bk} = P{A1} * P{A2} * P{A3} *···* P{Ak}
     *
     * 此时我们再从另一种角度想一下这个问题，
     * B(k-1)指的是(k-1)个人中，“两两”生日不等的事件。
     * 这B(k-1)事件意味着第1个人到第（k-1）个人的生日“已经互不相等了”，
     * 此时如果我们要“加上第k个人”，且“还是要他们所有人生日互不相等（即达到事件Bk）”，
     * 则只需要满足“第k个人的生日与第1人生日不同、且与第2人生日不同···且与第（k-1）人生日不同”这个事件即可。
     * （即只需要满足第k与第1到第k-1不同，而B(k-1)表示“第1到第k-1”已经两两互不相同了）
     * 转换成公式则为：
     * Bk = B(k-1) * Ak
     *
     * 由上一个思考角度继续思考，
     * 根据这个公式：Bk = B(k-1) * Ak，可知：
     * 这（k-1）个人各有各的生日，且互不重复，也就是说，一年365天里，他们的生日占了其中的(k-1)天。
     * Ak事件如果要达成，则第k个人的生日“不能是这（k-1）天中的任意一天”。
     * 那么Ak事件（即第k人生日与这（k-1）人生日都不相等）的概率就是：(n-(k-1))/n，（k的生日必须是这（k-1）天以外的某一天）。
     * 即：P{Ak} = (n-(k-1))/n
     *
     * 综上所述，我们能得到以下公式：
     * P{Bk}
     * = P{B(k-1)} * P{Ak}
     * = P{B(k-2)} * P{A(k-1)} * P{Ak}
     * = P{B(k-3)} * P{A(k-2)} * P{A(k-1)} * P{Ak}
     * ·····
     * = P{A1} * P{A2} * P{A3} *···*  P{A(k-1)} * P{Ak}
     * = 1 * ((n-(1))/n) * ((n-(2))/n) *···* ((n-(k-2))/n) * ((n-(k-1))/n)
     * = 1 * (1-(1/n)) * (1-(2/n)) *···* (1-((k-2)/n)) * ((1-((k-1)/n))
     */

    /**
     *
     * 由原题“生日相同的机会达到50%”，
     * 所以：1-P{Bk} >=50%，即：P{Bk} <= 1/2
     *
     * 下面就是使用一些数学知识求解了：
     * 根据不等式：1+x<=e^x ，将“-((k-1)/n)”看成不等式中的x，得：
     * P{Bk} <= e^(-(1/n)) *···* e^(-((k-1)/n))
     * P{Bk} <= e^((-k*(k-1))/2n)
     * e^((-k*(k-1))/2n) <= 1/2     （原题目要求）
     *
     * 将n=365时，
     * 解得：k>=23
     * 所以，一个屋子里人数必须要达到23人，才能使其中两人生日相同的机会达到50%
     */

    public static void main(String[] arg){
        int sum_day = 365;

        int sum_people = birth_paradox(sum_day);

        System.out.println("当一年有"+sum_day+"天时");
        System.out.println("一个屋子里人数必须要达到"+sum_people+"人，才能使其中两人生日相同的机会达到50%");
    }

    /**
     * 当一年有sum_day天时，
     * 一个屋子里人数必须要达到多少人，才能使其中两人生日相同的机会达到50%
     * @param sum_day 一年的总天数
     * @return 至少得有多少人，才能达到要求
     */
    public static int birth_paradox(double sum_day){
        //所需总人数
        int sum_people;

        //初始为P{A1}=1
        double Pb = 1;

        /**
         * 从第sum_people=1个人开始找起，看其两两生日不等时，事件概率是否成立。
         * 如果不成立，则sum_people+1。
         */
        for (sum_people = 1;sum_people<=sum_day+1;sum_people++){
            //P{Ak}
            double Pa = ((sum_day)-sum_people+1)/sum_day;

            //P{Bk} = P{B(k-1)} * P{Ak}
            Pb = Pb*Pa;

            //如果1-P{Bk} >=50%
            if ((1-Pb)>= 0.5){
                return sum_people;
            }
        }

        return sum_people;
    }
}
