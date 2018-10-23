package com.example.yida.demo3.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yida on 2018/10/23.
 */
public class RestBean {


    /**
     * R : 20140106
     * S : {"1001":[{"V":"世界音乐日","P":"2","Y":"1980"},{"V":"国际老人节","P":"2","Y":"1992"},{"V":"国庆节","P":"10","Y":"1949"}],"1002":[{"V":"国际和平与民主自由斗争日","P":"2","Y":"1949"}],"1004":[{"V":"世界动物日","P":"2","Y":"1931"}],"1005":[{"V":"国际教师节","P":"2","Y":"1994"}],"1008":[{"V":"世界视觉日","P":"2","Y":"2000"}],"1009":[{"V":"世界邮政日","P":"2","Y":"1969"},{"V":"万国邮联日","P":"2","Y":"1899"}],"1010":[{"V":"辛亥革命","P":"6","Y":"1911"}],"1011":[{"V":"世界镇痛日","P":"2","Y":"1949"}],"1013":[{"V":"世界保健日","P":"2","Y":"1950"}],"1014":[{"V":"世界标准日","P":"2","Y":"1946"}],"1015":[{"V":"国际盲人节(白手杖节)","P":"2","Y":"1984"}],"1016":[{"V":"世界粮食日","P":"2","Y":"1981"}],"1017":[{"V":"世界消除贫困日","P":"2","Y":"1992"}],"1022":[{"V":"世界传统医药日","P":"2","Y":"1991"}],"1024":[{"V":"联合国日","P":"2","Y":"1942"},{"V":"世界发展宣传日","P":"2","Y":"1942"}],"1031":[{"V":"万圣节","P":"9","Y":"1900"},{"V":"世界勤俭日","P":"2","Y":"1924"}],"1110":[{"V":"世界青年节","P":"2","Y":"1984"}],"1111":[{"V":"国际科学与和平周","P":"2","Y":"1988"}],"1112":[{"V":"孙中山诞辰纪念日","P":"2","Y":"1866"}],"1114":[{"V":"世界糖尿病日","P":"2","Y":"1991"}],"1116":[{"V":"国际宽容日","P":"2","Y":"1949"}],"1117":[{"V":"国际大学生节","P":"2","Y":"1946"}],"1121":[{"V":"世界问候日","P":"2","Y":"1973"},{"V":"世界电视日","P":"2","Y":"1996"}],"1125":[{"V":"消除对妇女的暴力日","P":"2","Y":"1949"}],"1129":[{"V":"国际声援巴勒斯坦人民国际日","P":"2","Y":"1977"}],"1201":[{"V":"艾滋病日","P":"6","Y":"1988"}],"1202":[{"V":"全国交通安全日","P":"2","Y":"2012"}],"1203":[{"V":"世界残疾人日","P":"2","Y":"1992"}],"1204":[{"V":"全国法制宣传日","P":"2","Y":"2001"}],"1205":[{"V":"世界弱能人士日","P":"2","Y":"1949"},{"V":"国际经济和社会发展志愿人员日","P":"2","Y":"1985"}],"1207":[{"V":"国际民航日","P":"2","Y":"1949"}],"1210":[{"V":"世界人权日","P":"2","Y":"1948"}],"1211":[{"V":"世界防治哮喘日","P":"2","Y":"1949"},{"V":"国际山岳日","P":"2","Y":"2003"}],"1212":[{"V":"西安事变","P":"2","Y":"1936"}],"1213":[{"V":"南京大屠杀死难者国家公祭日","P":"9","Y":"1937","L":"公祭日"}],"1215":[{"V":"世界强化免疫日","P":"2","Y":"1949"}],"1218":[{"V":"国际移徙者日","P":"2","Y":"2000"}],"1221":[{"V":"国际篮球日","P":"2","Y":"1891"}],"1224":[{"V":"平安夜","P":"9","Y":"1818"}],"1225":[{"V":"圣诞节","P":"10","Y":"1607"}],"1226":[{"V":"世界足球日","P":"2","Y":"1978"},{"V":"国际反腐败日","P":"2","Y":"1978"}],"0213":[{"V":"世界无线电日","P":"2","Y":"2013"}],"0221":[{"V":"国际母语日","P":"2","Y":"1999"}],"0306":[{"V":"世界青光眼日","P":"2","Y":"2008"}],"0318":[{"V":"全国爱肝日","P":"2","Y":"2001"}],"0408":[{"V":"国际珍稀动物保护日","P":"2","Y":"2000"}],"0411":[{"V":"世界帕金森病日","P":"2","Y":"1997"}],"0412":[{"V":"世界航天日","P":"2","Y":"2011"}],"0416":[{"V":"世界嗓音日","P":"2","Y":"2003"}],"0417":[{"V":"世界血友病日","P":"2","Y":"1989"}],"0425":[{"V":"全国儿童预防接种宣传日","P":"2","Y":"1986"}],"0429":[{"V":"世界舞蹈日","P":"2","Y":"1982"}],"0430":[{"V":"国际不打小孩日","P":"2","Y":"1998"}],"0525":[{"V":"世界预防中风日","P":"2","Y":"2004"}],"0528":[{"V":"全国爱发日","P":"2","Y":"2010"}],"0608":[{"V":"世界海洋日","P":"2","Y":"2009"}],"0611":[{"V":"中国人口日","P":"2","Y":"2000"}],"0612":[{"V":"世界无童工日","P":"2","Y":"2002"}],"0614":[{"V":"世界献血者日","P":"2","Y":"2005"}],"0706":[{"V":"国际接吻日","P":"2","Y":"1991"}],"0716":[{"V":"国际冰壶日","P":"2","Y":"2000"}],"0728":[{"V":"世界肝炎日","P":"2","Y":"2011"}],"0729":[{"V":"世界爱虎日","P":"2","Y":"2010"}],"0813":[{"V":"国际左撇子日","P":"2","Y":"1976"}],"0929":[{"V":"世界步行日","P":"2","Y":"1992"}],"0601":[{"V":"国际牛奶日","P":"2","Y":"1961"}],"0520":[{"V":"全国母乳喂养宣传日","P":"2","Y":"1949"}],"0901":[{"V":"全国中小学开学日","P":"2","Y":"1949"}],"0622":[{"V":"中国儿童慈善活动日","P":"2","Y":"1949"}],"0503":[{"V":"世界新闻自由日","P":"2","Y":"1949"}],"0426":[{"V":"世界知识产权日","P":"2","Y":"1949"}],"0402":[{"V":"国际儿童图书日","P":"2","Y":"1949"}],"0224":[{"V":"第三世界青年日","P":"2","Y":"1949"}],"0921":[{"V":"国际和平日","P":"2","Y":"2002"},{"V":"世界老年性痴呆宣传日","P":"2","Y":"2002"}],"0815":[{"V":"日本无条件投降日","P":"6","Y":"1945","L":"日本投降"}],"0927":[{"V":"世界旅游日","P":"2","Y":"1979"}],"0330":[{"V":"巴勒斯坦国土日","P":"2","Y":"1976"}],"0422":[{"V":"世界地球日","P":"6","Y":"1970","L":"地球日"},{"V":"世界法律日","P":"2","Y":"1970"}],"0916":[{"V":"国际臭氧层保护日","P":"2","Y":"1995"},{"V":"中国脑健康日","P":"2","Y":"2000"}],"0101":[{"V":"元旦节","P":"10","Y":"1912"}],"0928":[{"V":"孔子诞辰","P":"6","Y":"1899"},{"V":"世界狂犬病日","P":"2","Y":"2007"}],"0308":[{"V":"妇女节","P":"9","Y":"1909"}],"0423":[{"V":"世界图书和版权日","P":"2","Y":"1995"}],"0515":[{"V":"国际家庭日","P":"2","Y":"1994"},{"V":"国际家庭日","P":"2","Y":"1994"}],"0711":[{"V":"世界人口日","P":"2","Y":"1987"},{"V":"航海日","P":"2","Y":"2005"}],"0401":[{"V":"愚人节","P":"9","Y":"1983"}],"0424":[{"V":"亚非新闻工作者日","P":"2","Y":"1963"}],"0918":[{"V":"九一八事变纪念日","P":"6","Y":"1931","L":"九一八"}],"0321":[{"V":"世界森林日","P":"2","Y":"1971"},{"V":"消除种族歧视国际日","P":"2","Y":"1966"},{"V":"世界儿歌日","P":"2","Y":"1976"}],"0517":[{"V":"国际电信日","P":"2","Y":"1969"}],"0701":[{"V":"世界建筑日","P":"2","Y":"1985"},{"V":"香港回归","P":"10","Y":"1997"}],"0322":[{"V":"世界水日","P":"2","Y":"1993"}],"0908":[{"V":"国际扫盲日","P":"2","Y":"1965"},{"V":"国际新闻工作者日","P":"2","Y":"1958"}],"0920":[{"V":"国际爱牙日","P":"2","Y":"1989"}],"0518":[{"V":"博物馆日","P":"6","Y":"1977"}],"0702":[{"V":"国际体育记者日","P":"2","Y":"1995"}],"0323":[{"V":"世界气象日","P":"2","Y":"1950"}],"0312":[{"V":"孙中山逝世纪念日","P":"2","Y":"1925"}],"0301":[{"V":"国际海豹日","P":"2","Y":"1983"}],"0324":[{"V":"世界防治结核病日","P":"2","Y":"1995"}],"0508":[{"V":"世界红十字日","P":"2","Y":"1948"},{"V":"微笑日","P":"6","Y":"1948"}],"0531":[{"V":"世界无烟日","P":"6","Y":"1989","L":"无烟日"}],"0623":[{"V":"奥林匹克","P":"6","Y":"1948"}],"0210":[{"V":"国际气象节","P":"2","Y":"1991"}],"0407":[{"V":"世界卫生日","P":"2","Y":"1948"}],"0626":[{"V":"国际禁毒日","P":"2","Y":"1987"},{"V":"国际宪章日","P":"2","Y":"1987"}],"0903":[{"V":"抗日战争胜利纪念日","P":"6","Y":"1945","L":"抗战胜利"}],"0730":[{"V":"非洲妇女日","P":"2","Y":"1997"}],"0512":[{"V":"国际护士节","P":"6","Y":"1912","L":"护士节"}],"0914":[{"V":"世界清洁地球日","P":"2","Y":"2006"}],"0202":[{"V":"世界湿地日","P":"6","Y":"1997","L":"湿地日"}],"0501":[{"V":"劳动节","P":"10","Y":"1912"}],"0214":[{"V":"情人节","P":"9","Y":"1899"}],"0910":[{"V":"教师节","P":"9","Y":"1899"}],"0404":[{"V":"儿童节","P":"6","Y":"1931"}],"0605":[{"V":"世界环境保护日","P":"6","Y":"1972","L":"环保日"}]}
     * L : {"1208":[{"V":"腊八节","P":"9","Y":"1899"}],"1216":[{"V":"尾牙","P":"6","Y":"1899"}],"1223":[{"V":"小年","P":"9","Y":"1899"}],"1224":[{"V":"祭灶","P":"9","Y":"1899"}],"1230":[{"V":"除夕夜","P":"10","Y":"1899"}],"0303":[{"V":"上巳节","P":"6","Y":"1900"}],"0202":[{"V":"龙抬头","P":"9","Y":"1899"}],"0707":[{"V":"七夕节","P":"9","Y":"1899"}],"0505":[{"V":"端午节","P":"10","Y":"1899"}],"0815":[{"V":"中秋节","P":"10","Y":"1899"}],"0909":[{"V":"重阳节","P":"10","Y":"1899"}],"0101":[{"V":"春节","P":"10","Y":"1899"}],"0715":[{"V":"盂兰盆节","P":"9","Y":"1899"}],"0115":[{"V":"元宵节","P":"9","Y":"1899"}],"0408":[{"V":"佛陀诞辰","P":"10","Y":"1899"}]}
     * W : {"1011":[{"V":"国际住房日","P":"2","Y":"1985"}],"1013":[{"V":"国际减轻自然灾害日","P":"2","Y":"1987"}],"1024":[{"V":"世界视觉日","P":"2","Y":"2000"}],"1144":[{"V":"感恩节","P":"9","Y":"1941"}],"1220":[{"V":"国际儿童电视广播日","P":"2","Y":"1985"}],"0730":[{"V":"被奴役国家周","P":"2","Y":"1959"}],"0630":[{"V":"父亲节","P":"9","Y":"2005"}],"0520":[{"V":"母亲节","P":"9","Y":"1876"}],"0150":[{"V":"国际麻风节","P":"2","Y":"1953"}],"0940":[{"V":"国际聋人节","P":"2","Y":"1958"},{"V":"世界儿童日","P":"2","Y":"1986"}],"0950":[{"V":"世界心脏日","P":"2","Y":"1978"}]}
     */

    private String R;
    private SBean S;
    private LBean L;
    private WBean W;

    public String getR() {
        return R;
    }

    public void setR(String R) {
        this.R = R;
    }

    public SBean getS() {
        return S;
    }

    public void setS(SBean S) {
        this.S = S;
    }

    public LBean getL() {
        return L;
    }

    public void setL(LBean L) {
        this.L = L;
    }

    public WBean getW() {
        return W;
    }

    public void setW(WBean W) {
        this.W = W;
    }

    public static class SBean {
        @SerializedName("1001")
        private List<_$1001Bean> _$1001;
        @SerializedName("1002")
        private List<_$1002Bean> _$1002;
        @SerializedName("1004")
        private List<_$1004Bean> _$1004;
        @SerializedName("1005")
        private List<_$1005Bean> _$1005;
        @SerializedName("1008")
        private List<_$1008Bean> _$1008;
        @SerializedName("1009")
        private List<_$1009Bean> _$1009;
        @SerializedName("1010")
        private List<_$1010Bean> _$1010;
        @SerializedName("1011")
        private List<_$1011Bean> _$1011;
        @SerializedName("1013")
        private List<_$1013Bean> _$1013;
        @SerializedName("1014")
        private List<_$1014Bean> _$1014;
        @SerializedName("1015")
        private List<_$1015Bean> _$1015;
        @SerializedName("1016")
        private List<_$1016Bean> _$1016;
        @SerializedName("1017")
        private List<_$1017Bean> _$1017;
        @SerializedName("1022")
        private List<_$1022Bean> _$1022;
        @SerializedName("1024")
        private List<_$1024Bean> _$1024;
        @SerializedName("1031")
        private List<_$1031Bean> _$1031;
        @SerializedName("1110")
        private List<_$1110Bean> _$1110;
        @SerializedName("1111")
        private List<_$1111Bean> _$1111;
        @SerializedName("1112")
        private List<_$1112Bean> _$1112;
        @SerializedName("1114")
        private List<_$1114Bean> _$1114;
        @SerializedName("1116")
        private List<_$1116Bean> _$1116;
        @SerializedName("1117")
        private List<_$1117Bean> _$1117;
        @SerializedName("1121")
        private List<_$1121Bean> _$1121;
        @SerializedName("1125")
        private List<_$1125Bean> _$1125;
        @SerializedName("1129")
        private List<_$1129Bean> _$1129;
        @SerializedName("1201")
        private List<_$1201Bean> _$1201;
        @SerializedName("1202")
        private List<_$1202Bean> _$1202;
        @SerializedName("1203")
        private List<_$1203Bean> _$1203;
        @SerializedName("1204")
        private List<_$1204Bean> _$1204;
        @SerializedName("1205")
        private List<_$1205Bean> _$1205;
        @SerializedName("1207")
        private List<_$1207Bean> _$1207;
        @SerializedName("1210")
        private List<_$1210Bean> _$1210;
        @SerializedName("1211")
        private List<_$1211Bean> _$1211;
        @SerializedName("1212")
        private List<_$1212Bean> _$1212;
        @SerializedName("1213")
        private List<_$1213Bean> _$1213;
        @SerializedName("1215")
        private List<_$1215Bean> _$1215;
        @SerializedName("1218")
        private List<_$1218Bean> _$1218;
        @SerializedName("1221")
        private List<_$1221Bean> _$1221;
        @SerializedName("1224")
        private List<_$1224Bean> _$1224;
        @SerializedName("1225")
        private List<_$1225Bean> _$1225;
        @SerializedName("1226")
        private List<_$1226Bean> _$1226;
        @SerializedName("0213")
        private List<_$0213Bean> _$0213;
        @SerializedName("0221")
        private List<_$0221Bean> _$0221;
        @SerializedName("0306")
        private List<_$0306Bean> _$0306;
        @SerializedName("0318")
        private List<_$0318Bean> _$0318;
        @SerializedName("0408")
        private List<_$0408Bean> _$0408;
        @SerializedName("0411")
        private List<_$0411Bean> _$0411;
        @SerializedName("0412")
        private List<_$0412Bean> _$0412;
        @SerializedName("0416")
        private List<_$0416Bean> _$0416;
        @SerializedName("0417")
        private List<_$0417Bean> _$0417;
        @SerializedName("0425")
        private List<_$0425Bean> _$0425;
        @SerializedName("0429")
        private List<_$0429Bean> _$0429;
        @SerializedName("0430")
        private List<_$0430Bean> _$0430;
        @SerializedName("0525")
        private List<_$0525Bean> _$0525;
        @SerializedName("0528")
        private List<_$0528Bean> _$0528;
        @SerializedName("0608")
        private List<_$0608Bean> _$0608;
        @SerializedName("0611")
        private List<_$0611Bean> _$0611;
        @SerializedName("0612")
        private List<_$0612Bean> _$0612;
        @SerializedName("0614")
        private List<_$0614Bean> _$0614;
        @SerializedName("0706")
        private List<_$0706Bean> _$0706;
        @SerializedName("0716")
        private List<_$0716Bean> _$0716;
        @SerializedName("0728")
        private List<_$0728Bean> _$0728;
        @SerializedName("0729")
        private List<_$0729Bean> _$0729;
        @SerializedName("0813")
        private List<_$0813Bean> _$0813;
        @SerializedName("0929")
        private List<_$0929Bean> _$0929;
        @SerializedName("0601")
        private List<_$0601Bean> _$0601;
        @SerializedName("0520")
        private List<_$0520Bean> _$0520;
        @SerializedName("0901")
        private List<_$0901Bean> _$0901;
        @SerializedName("0622")
        private List<_$0622Bean> _$0622;
        @SerializedName("0503")
        private List<_$0503Bean> _$0503;
        @SerializedName("0426")
        private List<_$0426Bean> _$0426;
        @SerializedName("0402")
        private List<_$0402Bean> _$0402;
        @SerializedName("0224")
        private List<_$0224Bean> _$0224;
        @SerializedName("0921")
        private List<_$0921Bean> _$0921;
        @SerializedName("0815")
        private List<_$0815Bean> _$0815;
        @SerializedName("0927")
        private List<_$0927Bean> _$0927;
        @SerializedName("0330")
        private List<_$0330Bean> _$0330;
        @SerializedName("0422")
        private List<_$0422Bean> _$0422;
        @SerializedName("0916")
        private List<_$0916Bean> _$0916;
        @SerializedName("0101")
        private List<_$0101Bean> _$0101;
        @SerializedName("0928")
        private List<_$0928Bean> _$0928;
        @SerializedName("0308")
        private List<_$0308Bean> _$0308;
        @SerializedName("0423")
        private List<_$0423Bean> _$0423;
        @SerializedName("0515")
        private List<_$0515Bean> _$0515;
        @SerializedName("0711")
        private List<_$0711Bean> _$0711;
        @SerializedName("0401")
        private List<_$0401Bean> _$0401;
        @SerializedName("0424")
        private List<_$0424Bean> _$0424;
        @SerializedName("0918")
        private List<_$0918Bean> _$0918;
        @SerializedName("0321")
        private List<_$0321Bean> _$0321;
        @SerializedName("0517")
        private List<_$0517Bean> _$0517;
        @SerializedName("0701")
        private List<_$0701Bean> _$0701;
        @SerializedName("0322")
        private List<_$0322Bean> _$0322;
        @SerializedName("0908")
        private List<_$0908Bean> _$0908;
        @SerializedName("0920")
        private List<_$0920Bean> _$0920;
        @SerializedName("0518")
        private List<_$0518Bean> _$0518;
        @SerializedName("0702")
        private List<_$0702Bean> _$0702;
        @SerializedName("0323")
        private List<_$0323Bean> _$0323;
        @SerializedName("0312")
        private List<_$0312Bean> _$0312;
        @SerializedName("0301")
        private List<_$0301Bean> _$0301;
        @SerializedName("0324")
        private List<_$0324Bean> _$0324;
        @SerializedName("0508")
        private List<_$0508Bean> _$0508;
        @SerializedName("0531")
        private List<_$0531Bean> _$0531;
        @SerializedName("0623")
        private List<_$0623Bean> _$0623;
        @SerializedName("0210")
        private List<_$0210Bean> _$0210;
        @SerializedName("0407")
        private List<_$0407Bean> _$0407;
        @SerializedName("0626")
        private List<_$0626Bean> _$0626;
        @SerializedName("0903")
        private List<_$0903Bean> _$0903;
        @SerializedName("0730")
        private List<_$0730Bean> _$0730;
        @SerializedName("0512")
        private List<_$0512Bean> _$0512;
        @SerializedName("0914")
        private List<_$0914Bean> _$0914;
        @SerializedName("0202")
        private List<_$0202Bean> _$0202;
        @SerializedName("0501")
        private List<_$0501Bean> _$0501;
        @SerializedName("0214")
        private List<_$0214Bean> _$0214;
        @SerializedName("0910")
        private List<_$0910Bean> _$0910;
        @SerializedName("0404")
        private List<_$0404Bean> _$0404;
        @SerializedName("0605")
        private List<_$0605Bean> _$0605;

        public List<_$1001Bean> get_$1001() {
            return _$1001;
        }

        public void set_$1001(List<_$1001Bean> _$1001) {
            this._$1001 = _$1001;
        }

        public List<_$1002Bean> get_$1002() {
            return _$1002;
        }

        public void set_$1002(List<_$1002Bean> _$1002) {
            this._$1002 = _$1002;
        }

        public List<_$1004Bean> get_$1004() {
            return _$1004;
        }

        public void set_$1004(List<_$1004Bean> _$1004) {
            this._$1004 = _$1004;
        }

        public List<_$1005Bean> get_$1005() {
            return _$1005;
        }

        public void set_$1005(List<_$1005Bean> _$1005) {
            this._$1005 = _$1005;
        }

        public List<_$1008Bean> get_$1008() {
            return _$1008;
        }

        public void set_$1008(List<_$1008Bean> _$1008) {
            this._$1008 = _$1008;
        }

        public List<_$1009Bean> get_$1009() {
            return _$1009;
        }

        public void set_$1009(List<_$1009Bean> _$1009) {
            this._$1009 = _$1009;
        }

        public List<_$1010Bean> get_$1010() {
            return _$1010;
        }

        public void set_$1010(List<_$1010Bean> _$1010) {
            this._$1010 = _$1010;
        }

        public List<_$1011Bean> get_$1011() {
            return _$1011;
        }

        public void set_$1011(List<_$1011Bean> _$1011) {
            this._$1011 = _$1011;
        }

        public List<_$1013Bean> get_$1013() {
            return _$1013;
        }

        public void set_$1013(List<_$1013Bean> _$1013) {
            this._$1013 = _$1013;
        }

        public List<_$1014Bean> get_$1014() {
            return _$1014;
        }

        public void set_$1014(List<_$1014Bean> _$1014) {
            this._$1014 = _$1014;
        }

        public List<_$1015Bean> get_$1015() {
            return _$1015;
        }

        public void set_$1015(List<_$1015Bean> _$1015) {
            this._$1015 = _$1015;
        }

        public List<_$1016Bean> get_$1016() {
            return _$1016;
        }

        public void set_$1016(List<_$1016Bean> _$1016) {
            this._$1016 = _$1016;
        }

        public List<_$1017Bean> get_$1017() {
            return _$1017;
        }

        public void set_$1017(List<_$1017Bean> _$1017) {
            this._$1017 = _$1017;
        }

        public List<_$1022Bean> get_$1022() {
            return _$1022;
        }

        public void set_$1022(List<_$1022Bean> _$1022) {
            this._$1022 = _$1022;
        }

        public List<_$1024Bean> get_$1024() {
            return _$1024;
        }

        public void set_$1024(List<_$1024Bean> _$1024) {
            this._$1024 = _$1024;
        }

        public List<_$1031Bean> get_$1031() {
            return _$1031;
        }

        public void set_$1031(List<_$1031Bean> _$1031) {
            this._$1031 = _$1031;
        }

        public List<_$1110Bean> get_$1110() {
            return _$1110;
        }

        public void set_$1110(List<_$1110Bean> _$1110) {
            this._$1110 = _$1110;
        }

        public List<_$1111Bean> get_$1111() {
            return _$1111;
        }

        public void set_$1111(List<_$1111Bean> _$1111) {
            this._$1111 = _$1111;
        }

        public List<_$1112Bean> get_$1112() {
            return _$1112;
        }

        public void set_$1112(List<_$1112Bean> _$1112) {
            this._$1112 = _$1112;
        }

        public List<_$1114Bean> get_$1114() {
            return _$1114;
        }

        public void set_$1114(List<_$1114Bean> _$1114) {
            this._$1114 = _$1114;
        }

        public List<_$1116Bean> get_$1116() {
            return _$1116;
        }

        public void set_$1116(List<_$1116Bean> _$1116) {
            this._$1116 = _$1116;
        }

        public List<_$1117Bean> get_$1117() {
            return _$1117;
        }

        public void set_$1117(List<_$1117Bean> _$1117) {
            this._$1117 = _$1117;
        }

        public List<_$1121Bean> get_$1121() {
            return _$1121;
        }

        public void set_$1121(List<_$1121Bean> _$1121) {
            this._$1121 = _$1121;
        }

        public List<_$1125Bean> get_$1125() {
            return _$1125;
        }

        public void set_$1125(List<_$1125Bean> _$1125) {
            this._$1125 = _$1125;
        }

        public List<_$1129Bean> get_$1129() {
            return _$1129;
        }

        public void set_$1129(List<_$1129Bean> _$1129) {
            this._$1129 = _$1129;
        }

        public List<_$1201Bean> get_$1201() {
            return _$1201;
        }

        public void set_$1201(List<_$1201Bean> _$1201) {
            this._$1201 = _$1201;
        }

        public List<_$1202Bean> get_$1202() {
            return _$1202;
        }

        public void set_$1202(List<_$1202Bean> _$1202) {
            this._$1202 = _$1202;
        }

        public List<_$1203Bean> get_$1203() {
            return _$1203;
        }

        public void set_$1203(List<_$1203Bean> _$1203) {
            this._$1203 = _$1203;
        }

        public List<_$1204Bean> get_$1204() {
            return _$1204;
        }

        public void set_$1204(List<_$1204Bean> _$1204) {
            this._$1204 = _$1204;
        }

        public List<_$1205Bean> get_$1205() {
            return _$1205;
        }

        public void set_$1205(List<_$1205Bean> _$1205) {
            this._$1205 = _$1205;
        }

        public List<_$1207Bean> get_$1207() {
            return _$1207;
        }

        public void set_$1207(List<_$1207Bean> _$1207) {
            this._$1207 = _$1207;
        }

        public List<_$1210Bean> get_$1210() {
            return _$1210;
        }

        public void set_$1210(List<_$1210Bean> _$1210) {
            this._$1210 = _$1210;
        }

        public List<_$1211Bean> get_$1211() {
            return _$1211;
        }

        public void set_$1211(List<_$1211Bean> _$1211) {
            this._$1211 = _$1211;
        }

        public List<_$1212Bean> get_$1212() {
            return _$1212;
        }

        public void set_$1212(List<_$1212Bean> _$1212) {
            this._$1212 = _$1212;
        }

        public List<_$1213Bean> get_$1213() {
            return _$1213;
        }

        public void set_$1213(List<_$1213Bean> _$1213) {
            this._$1213 = _$1213;
        }

        public List<_$1215Bean> get_$1215() {
            return _$1215;
        }

        public void set_$1215(List<_$1215Bean> _$1215) {
            this._$1215 = _$1215;
        }

        public List<_$1218Bean> get_$1218() {
            return _$1218;
        }

        public void set_$1218(List<_$1218Bean> _$1218) {
            this._$1218 = _$1218;
        }

        public List<_$1221Bean> get_$1221() {
            return _$1221;
        }

        public void set_$1221(List<_$1221Bean> _$1221) {
            this._$1221 = _$1221;
        }

        public List<_$1224Bean> get_$1224() {
            return _$1224;
        }

        public void set_$1224(List<_$1224Bean> _$1224) {
            this._$1224 = _$1224;
        }

        public List<_$1225Bean> get_$1225() {
            return _$1225;
        }

        public void set_$1225(List<_$1225Bean> _$1225) {
            this._$1225 = _$1225;
        }

        public List<_$1226Bean> get_$1226() {
            return _$1226;
        }

        public void set_$1226(List<_$1226Bean> _$1226) {
            this._$1226 = _$1226;
        }

        public List<_$0213Bean> get_$0213() {
            return _$0213;
        }

        public void set_$0213(List<_$0213Bean> _$0213) {
            this._$0213 = _$0213;
        }

        public List<_$0221Bean> get_$0221() {
            return _$0221;
        }

        public void set_$0221(List<_$0221Bean> _$0221) {
            this._$0221 = _$0221;
        }

        public List<_$0306Bean> get_$0306() {
            return _$0306;
        }

        public void set_$0306(List<_$0306Bean> _$0306) {
            this._$0306 = _$0306;
        }

        public List<_$0318Bean> get_$0318() {
            return _$0318;
        }

        public void set_$0318(List<_$0318Bean> _$0318) {
            this._$0318 = _$0318;
        }

        public List<_$0408Bean> get_$0408() {
            return _$0408;
        }

        public void set_$0408(List<_$0408Bean> _$0408) {
            this._$0408 = _$0408;
        }

        public List<_$0411Bean> get_$0411() {
            return _$0411;
        }

        public void set_$0411(List<_$0411Bean> _$0411) {
            this._$0411 = _$0411;
        }

        public List<_$0412Bean> get_$0412() {
            return _$0412;
        }

        public void set_$0412(List<_$0412Bean> _$0412) {
            this._$0412 = _$0412;
        }

        public List<_$0416Bean> get_$0416() {
            return _$0416;
        }

        public void set_$0416(List<_$0416Bean> _$0416) {
            this._$0416 = _$0416;
        }

        public List<_$0417Bean> get_$0417() {
            return _$0417;
        }

        public void set_$0417(List<_$0417Bean> _$0417) {
            this._$0417 = _$0417;
        }

        public List<_$0425Bean> get_$0425() {
            return _$0425;
        }

        public void set_$0425(List<_$0425Bean> _$0425) {
            this._$0425 = _$0425;
        }

        public List<_$0429Bean> get_$0429() {
            return _$0429;
        }

        public void set_$0429(List<_$0429Bean> _$0429) {
            this._$0429 = _$0429;
        }

        public List<_$0430Bean> get_$0430() {
            return _$0430;
        }

        public void set_$0430(List<_$0430Bean> _$0430) {
            this._$0430 = _$0430;
        }

        public List<_$0525Bean> get_$0525() {
            return _$0525;
        }

        public void set_$0525(List<_$0525Bean> _$0525) {
            this._$0525 = _$0525;
        }

        public List<_$0528Bean> get_$0528() {
            return _$0528;
        }

        public void set_$0528(List<_$0528Bean> _$0528) {
            this._$0528 = _$0528;
        }

        public List<_$0608Bean> get_$0608() {
            return _$0608;
        }

        public void set_$0608(List<_$0608Bean> _$0608) {
            this._$0608 = _$0608;
        }

        public List<_$0611Bean> get_$0611() {
            return _$0611;
        }

        public void set_$0611(List<_$0611Bean> _$0611) {
            this._$0611 = _$0611;
        }

        public List<_$0612Bean> get_$0612() {
            return _$0612;
        }

        public void set_$0612(List<_$0612Bean> _$0612) {
            this._$0612 = _$0612;
        }

        public List<_$0614Bean> get_$0614() {
            return _$0614;
        }

        public void set_$0614(List<_$0614Bean> _$0614) {
            this._$0614 = _$0614;
        }

        public List<_$0706Bean> get_$0706() {
            return _$0706;
        }

        public void set_$0706(List<_$0706Bean> _$0706) {
            this._$0706 = _$0706;
        }

        public List<_$0716Bean> get_$0716() {
            return _$0716;
        }

        public void set_$0716(List<_$0716Bean> _$0716) {
            this._$0716 = _$0716;
        }

        public List<_$0728Bean> get_$0728() {
            return _$0728;
        }

        public void set_$0728(List<_$0728Bean> _$0728) {
            this._$0728 = _$0728;
        }

        public List<_$0729Bean> get_$0729() {
            return _$0729;
        }

        public void set_$0729(List<_$0729Bean> _$0729) {
            this._$0729 = _$0729;
        }

        public List<_$0813Bean> get_$0813() {
            return _$0813;
        }

        public void set_$0813(List<_$0813Bean> _$0813) {
            this._$0813 = _$0813;
        }

        public List<_$0929Bean> get_$0929() {
            return _$0929;
        }

        public void set_$0929(List<_$0929Bean> _$0929) {
            this._$0929 = _$0929;
        }

        public List<_$0601Bean> get_$0601() {
            return _$0601;
        }

        public void set_$0601(List<_$0601Bean> _$0601) {
            this._$0601 = _$0601;
        }

        public List<_$0520Bean> get_$0520() {
            return _$0520;
        }

        public void set_$0520(List<_$0520Bean> _$0520) {
            this._$0520 = _$0520;
        }

        public List<_$0901Bean> get_$0901() {
            return _$0901;
        }

        public void set_$0901(List<_$0901Bean> _$0901) {
            this._$0901 = _$0901;
        }

        public List<_$0622Bean> get_$0622() {
            return _$0622;
        }

        public void set_$0622(List<_$0622Bean> _$0622) {
            this._$0622 = _$0622;
        }

        public List<_$0503Bean> get_$0503() {
            return _$0503;
        }

        public void set_$0503(List<_$0503Bean> _$0503) {
            this._$0503 = _$0503;
        }

        public List<_$0426Bean> get_$0426() {
            return _$0426;
        }

        public void set_$0426(List<_$0426Bean> _$0426) {
            this._$0426 = _$0426;
        }

        public List<_$0402Bean> get_$0402() {
            return _$0402;
        }

        public void set_$0402(List<_$0402Bean> _$0402) {
            this._$0402 = _$0402;
        }

        public List<_$0224Bean> get_$0224() {
            return _$0224;
        }

        public void set_$0224(List<_$0224Bean> _$0224) {
            this._$0224 = _$0224;
        }

        public List<_$0921Bean> get_$0921() {
            return _$0921;
        }

        public void set_$0921(List<_$0921Bean> _$0921) {
            this._$0921 = _$0921;
        }

        public List<_$0815Bean> get_$0815() {
            return _$0815;
        }

        public void set_$0815(List<_$0815Bean> _$0815) {
            this._$0815 = _$0815;
        }

        public List<_$0927Bean> get_$0927() {
            return _$0927;
        }

        public void set_$0927(List<_$0927Bean> _$0927) {
            this._$0927 = _$0927;
        }

        public List<_$0330Bean> get_$0330() {
            return _$0330;
        }

        public void set_$0330(List<_$0330Bean> _$0330) {
            this._$0330 = _$0330;
        }

        public List<_$0422Bean> get_$0422() {
            return _$0422;
        }

        public void set_$0422(List<_$0422Bean> _$0422) {
            this._$0422 = _$0422;
        }

        public List<_$0916Bean> get_$0916() {
            return _$0916;
        }

        public void set_$0916(List<_$0916Bean> _$0916) {
            this._$0916 = _$0916;
        }

        public List<_$0101Bean> get_$0101() {
            return _$0101;
        }

        public void set_$0101(List<_$0101Bean> _$0101) {
            this._$0101 = _$0101;
        }

        public List<_$0928Bean> get_$0928() {
            return _$0928;
        }

        public void set_$0928(List<_$0928Bean> _$0928) {
            this._$0928 = _$0928;
        }

        public List<_$0308Bean> get_$0308() {
            return _$0308;
        }

        public void set_$0308(List<_$0308Bean> _$0308) {
            this._$0308 = _$0308;
        }

        public List<_$0423Bean> get_$0423() {
            return _$0423;
        }

        public void set_$0423(List<_$0423Bean> _$0423) {
            this._$0423 = _$0423;
        }

        public List<_$0515Bean> get_$0515() {
            return _$0515;
        }

        public void set_$0515(List<_$0515Bean> _$0515) {
            this._$0515 = _$0515;
        }

        public List<_$0711Bean> get_$0711() {
            return _$0711;
        }

        public void set_$0711(List<_$0711Bean> _$0711) {
            this._$0711 = _$0711;
        }

        public List<_$0401Bean> get_$0401() {
            return _$0401;
        }

        public void set_$0401(List<_$0401Bean> _$0401) {
            this._$0401 = _$0401;
        }

        public List<_$0424Bean> get_$0424() {
            return _$0424;
        }

        public void set_$0424(List<_$0424Bean> _$0424) {
            this._$0424 = _$0424;
        }

        public List<_$0918Bean> get_$0918() {
            return _$0918;
        }

        public void set_$0918(List<_$0918Bean> _$0918) {
            this._$0918 = _$0918;
        }

        public List<_$0321Bean> get_$0321() {
            return _$0321;
        }

        public void set_$0321(List<_$0321Bean> _$0321) {
            this._$0321 = _$0321;
        }

        public List<_$0517Bean> get_$0517() {
            return _$0517;
        }

        public void set_$0517(List<_$0517Bean> _$0517) {
            this._$0517 = _$0517;
        }

        public List<_$0701Bean> get_$0701() {
            return _$0701;
        }

        public void set_$0701(List<_$0701Bean> _$0701) {
            this._$0701 = _$0701;
        }

        public List<_$0322Bean> get_$0322() {
            return _$0322;
        }

        public void set_$0322(List<_$0322Bean> _$0322) {
            this._$0322 = _$0322;
        }

        public List<_$0908Bean> get_$0908() {
            return _$0908;
        }

        public void set_$0908(List<_$0908Bean> _$0908) {
            this._$0908 = _$0908;
        }

        public List<_$0920Bean> get_$0920() {
            return _$0920;
        }

        public void set_$0920(List<_$0920Bean> _$0920) {
            this._$0920 = _$0920;
        }

        public List<_$0518Bean> get_$0518() {
            return _$0518;
        }

        public void set_$0518(List<_$0518Bean> _$0518) {
            this._$0518 = _$0518;
        }

        public List<_$0702Bean> get_$0702() {
            return _$0702;
        }

        public void set_$0702(List<_$0702Bean> _$0702) {
            this._$0702 = _$0702;
        }

        public List<_$0323Bean> get_$0323() {
            return _$0323;
        }

        public void set_$0323(List<_$0323Bean> _$0323) {
            this._$0323 = _$0323;
        }

        public List<_$0312Bean> get_$0312() {
            return _$0312;
        }

        public void set_$0312(List<_$0312Bean> _$0312) {
            this._$0312 = _$0312;
        }

        public List<_$0301Bean> get_$0301() {
            return _$0301;
        }

        public void set_$0301(List<_$0301Bean> _$0301) {
            this._$0301 = _$0301;
        }

        public List<_$0324Bean> get_$0324() {
            return _$0324;
        }

        public void set_$0324(List<_$0324Bean> _$0324) {
            this._$0324 = _$0324;
        }

        public List<_$0508Bean> get_$0508() {
            return _$0508;
        }

        public void set_$0508(List<_$0508Bean> _$0508) {
            this._$0508 = _$0508;
        }

        public List<_$0531Bean> get_$0531() {
            return _$0531;
        }

        public void set_$0531(List<_$0531Bean> _$0531) {
            this._$0531 = _$0531;
        }

        public List<_$0623Bean> get_$0623() {
            return _$0623;
        }

        public void set_$0623(List<_$0623Bean> _$0623) {
            this._$0623 = _$0623;
        }

        public List<_$0210Bean> get_$0210() {
            return _$0210;
        }

        public void set_$0210(List<_$0210Bean> _$0210) {
            this._$0210 = _$0210;
        }

        public List<_$0407Bean> get_$0407() {
            return _$0407;
        }

        public void set_$0407(List<_$0407Bean> _$0407) {
            this._$0407 = _$0407;
        }

        public List<_$0626Bean> get_$0626() {
            return _$0626;
        }

        public void set_$0626(List<_$0626Bean> _$0626) {
            this._$0626 = _$0626;
        }

        public List<_$0903Bean> get_$0903() {
            return _$0903;
        }

        public void set_$0903(List<_$0903Bean> _$0903) {
            this._$0903 = _$0903;
        }

        public List<_$0730Bean> get_$0730() {
            return _$0730;
        }

        public void set_$0730(List<_$0730Bean> _$0730) {
            this._$0730 = _$0730;
        }

        public List<_$0512Bean> get_$0512() {
            return _$0512;
        }

        public void set_$0512(List<_$0512Bean> _$0512) {
            this._$0512 = _$0512;
        }

        public List<_$0914Bean> get_$0914() {
            return _$0914;
        }

        public void set_$0914(List<_$0914Bean> _$0914) {
            this._$0914 = _$0914;
        }

        public List<_$0202Bean> get_$0202() {
            return _$0202;
        }

        public void set_$0202(List<_$0202Bean> _$0202) {
            this._$0202 = _$0202;
        }

        public List<_$0501Bean> get_$0501() {
            return _$0501;
        }

        public void set_$0501(List<_$0501Bean> _$0501) {
            this._$0501 = _$0501;
        }

        public List<_$0214Bean> get_$0214() {
            return _$0214;
        }

        public void set_$0214(List<_$0214Bean> _$0214) {
            this._$0214 = _$0214;
        }

        public List<_$0910Bean> get_$0910() {
            return _$0910;
        }

        public void set_$0910(List<_$0910Bean> _$0910) {
            this._$0910 = _$0910;
        }

        public List<_$0404Bean> get_$0404() {
            return _$0404;
        }

        public void set_$0404(List<_$0404Bean> _$0404) {
            this._$0404 = _$0404;
        }

        public List<_$0605Bean> get_$0605() {
            return _$0605;
        }

        public void set_$0605(List<_$0605Bean> _$0605) {
            this._$0605 = _$0605;
        }

        public static class _$1001Bean {
            /**
             * V : 世界音乐日
             * P : 2
             * Y : 1980
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1002Bean {
            /**
             * V : 国际和平与民主自由斗争日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1004Bean {
            /**
             * V : 世界动物日
             * P : 2
             * Y : 1931
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1005Bean {
            /**
             * V : 国际教师节
             * P : 2
             * Y : 1994
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1008Bean {
            /**
             * V : 世界视觉日
             * P : 2
             * Y : 2000
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1009Bean {
            /**
             * V : 世界邮政日
             * P : 2
             * Y : 1969
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1010Bean {
            /**
             * V : 辛亥革命
             * P : 6
             * Y : 1911
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1011Bean {
            /**
             * V : 世界镇痛日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1013Bean {
            /**
             * V : 世界保健日
             * P : 2
             * Y : 1950
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1014Bean {
            /**
             * V : 世界标准日
             * P : 2
             * Y : 1946
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1015Bean {
            /**
             * V : 国际盲人节(白手杖节)
             * P : 2
             * Y : 1984
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1016Bean {
            /**
             * V : 世界粮食日
             * P : 2
             * Y : 1981
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1017Bean {
            /**
             * V : 世界消除贫困日
             * P : 2
             * Y : 1992
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1022Bean {
            /**
             * V : 世界传统医药日
             * P : 2
             * Y : 1991
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1024Bean {
            /**
             * V : 联合国日
             * P : 2
             * Y : 1942
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1031Bean {
            /**
             * V : 万圣节
             * P : 9
             * Y : 1900
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1110Bean {
            /**
             * V : 世界青年节
             * P : 2
             * Y : 1984
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1111Bean {
            /**
             * V : 国际科学与和平周
             * P : 2
             * Y : 1988
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1112Bean {
            /**
             * V : 孙中山诞辰纪念日
             * P : 2
             * Y : 1866
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1114Bean {
            /**
             * V : 世界糖尿病日
             * P : 2
             * Y : 1991
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1116Bean {
            /**
             * V : 国际宽容日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1117Bean {
            /**
             * V : 国际大学生节
             * P : 2
             * Y : 1946
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1121Bean {
            /**
             * V : 世界问候日
             * P : 2
             * Y : 1973
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1125Bean {
            /**
             * V : 消除对妇女的暴力日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1129Bean {
            /**
             * V : 国际声援巴勒斯坦人民国际日
             * P : 2
             * Y : 1977
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1201Bean {
            /**
             * V : 艾滋病日
             * P : 6
             * Y : 1988
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1202Bean {
            /**
             * V : 全国交通安全日
             * P : 2
             * Y : 2012
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1203Bean {
            /**
             * V : 世界残疾人日
             * P : 2
             * Y : 1992
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1204Bean {
            /**
             * V : 全国法制宣传日
             * P : 2
             * Y : 2001
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1205Bean {
            /**
             * V : 世界弱能人士日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1207Bean {
            /**
             * V : 国际民航日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1210Bean {
            /**
             * V : 世界人权日
             * P : 2
             * Y : 1948
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1211Bean {
            /**
             * V : 世界防治哮喘日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1212Bean {
            /**
             * V : 西安事变
             * P : 2
             * Y : 1936
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1213Bean {
            /**
             * V : 南京大屠杀死难者国家公祭日
             * P : 9
             * Y : 1937
             * L : 公祭日
             */

            private String V;
            private String P;
            private String Y;
            private String L;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }

            public String getL() {
                return L;
            }

            public void setL(String L) {
                this.L = L;
            }
        }

        public static class _$1215Bean {
            /**
             * V : 世界强化免疫日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1218Bean {
            /**
             * V : 国际移徙者日
             * P : 2
             * Y : 2000
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1221Bean {
            /**
             * V : 国际篮球日
             * P : 2
             * Y : 1891
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1224Bean {
            /**
             * V : 平安夜
             * P : 9
             * Y : 1818
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1225Bean {
            /**
             * V : 圣诞节
             * P : 10
             * Y : 1607
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1226Bean {
            /**
             * V : 世界足球日
             * P : 2
             * Y : 1978
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0213Bean {
            /**
             * V : 世界无线电日
             * P : 2
             * Y : 2013
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0221Bean {
            /**
             * V : 国际母语日
             * P : 2
             * Y : 1999
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0306Bean {
            /**
             * V : 世界青光眼日
             * P : 2
             * Y : 2008
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0318Bean {
            /**
             * V : 全国爱肝日
             * P : 2
             * Y : 2001
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0408Bean {
            /**
             * V : 国际珍稀动物保护日
             * P : 2
             * Y : 2000
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0411Bean {
            /**
             * V : 世界帕金森病日
             * P : 2
             * Y : 1997
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0412Bean {
            /**
             * V : 世界航天日
             * P : 2
             * Y : 2011
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0416Bean {
            /**
             * V : 世界嗓音日
             * P : 2
             * Y : 2003
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0417Bean {
            /**
             * V : 世界血友病日
             * P : 2
             * Y : 1989
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0425Bean {
            /**
             * V : 全国儿童预防接种宣传日
             * P : 2
             * Y : 1986
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0429Bean {
            /**
             * V : 世界舞蹈日
             * P : 2
             * Y : 1982
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0430Bean {
            /**
             * V : 国际不打小孩日
             * P : 2
             * Y : 1998
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0525Bean {
            /**
             * V : 世界预防中风日
             * P : 2
             * Y : 2004
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0528Bean {
            /**
             * V : 全国爱发日
             * P : 2
             * Y : 2010
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0608Bean {
            /**
             * V : 世界海洋日
             * P : 2
             * Y : 2009
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0611Bean {
            /**
             * V : 中国人口日
             * P : 2
             * Y : 2000
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0612Bean {
            /**
             * V : 世界无童工日
             * P : 2
             * Y : 2002
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0614Bean {
            /**
             * V : 世界献血者日
             * P : 2
             * Y : 2005
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0706Bean {
            /**
             * V : 国际接吻日
             * P : 2
             * Y : 1991
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0716Bean {
            /**
             * V : 国际冰壶日
             * P : 2
             * Y : 2000
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0728Bean {
            /**
             * V : 世界肝炎日
             * P : 2
             * Y : 2011
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0729Bean {
            /**
             * V : 世界爱虎日
             * P : 2
             * Y : 2010
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0813Bean {
            /**
             * V : 国际左撇子日
             * P : 2
             * Y : 1976
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0929Bean {
            /**
             * V : 世界步行日
             * P : 2
             * Y : 1992
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0601Bean {
            /**
             * V : 国际牛奶日
             * P : 2
             * Y : 1961
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0520Bean {
            /**
             * V : 全国母乳喂养宣传日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0901Bean {
            /**
             * V : 全国中小学开学日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0622Bean {
            /**
             * V : 中国儿童慈善活动日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0503Bean {
            /**
             * V : 世界新闻自由日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0426Bean {
            /**
             * V : 世界知识产权日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0402Bean {
            /**
             * V : 国际儿童图书日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0224Bean {
            /**
             * V : 第三世界青年日
             * P : 2
             * Y : 1949
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0921Bean {
            /**
             * V : 国际和平日
             * P : 2
             * Y : 2002
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0815Bean {
            /**
             * V : 日本无条件投降日
             * P : 6
             * Y : 1945
             * L : 日本投降
             */

            private String V;
            private String P;
            private String Y;
            private String L;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }

            public String getL() {
                return L;
            }

            public void setL(String L) {
                this.L = L;
            }
        }

        public static class _$0927Bean {
            /**
             * V : 世界旅游日
             * P : 2
             * Y : 1979
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0330Bean {
            /**
             * V : 巴勒斯坦国土日
             * P : 2
             * Y : 1976
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0422Bean {
            /**
             * V : 世界地球日
             * P : 6
             * Y : 1970
             * L : 地球日
             */

            private String V;
            private String P;
            private String Y;
            private String L;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }

            public String getL() {
                return L;
            }

            public void setL(String L) {
                this.L = L;
            }
        }

        public static class _$0916Bean {
            /**
             * V : 国际臭氧层保护日
             * P : 2
             * Y : 1995
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0101Bean {
            /**
             * V : 元旦节
             * P : 10
             * Y : 1912
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0928Bean {
            /**
             * V : 孔子诞辰
             * P : 6
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0308Bean {
            /**
             * V : 妇女节
             * P : 9
             * Y : 1909
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0423Bean {
            /**
             * V : 世界图书和版权日
             * P : 2
             * Y : 1995
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0515Bean {
            /**
             * V : 国际家庭日
             * P : 2
             * Y : 1994
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0711Bean {
            /**
             * V : 世界人口日
             * P : 2
             * Y : 1987
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0401Bean {
            /**
             * V : 愚人节
             * P : 9
             * Y : 1983
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0424Bean {
            /**
             * V : 亚非新闻工作者日
             * P : 2
             * Y : 1963
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0918Bean {
            /**
             * V : 九一八事变纪念日
             * P : 6
             * Y : 1931
             * L : 九一八
             */

            private String V;
            private String P;
            private String Y;
            private String L;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }

            public String getL() {
                return L;
            }

            public void setL(String L) {
                this.L = L;
            }
        }

        public static class _$0321Bean {
            /**
             * V : 世界森林日
             * P : 2
             * Y : 1971
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0517Bean {
            /**
             * V : 国际电信日
             * P : 2
             * Y : 1969
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0701Bean {
            /**
             * V : 世界建筑日
             * P : 2
             * Y : 1985
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0322Bean {
            /**
             * V : 世界水日
             * P : 2
             * Y : 1993
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0908Bean {
            /**
             * V : 国际扫盲日
             * P : 2
             * Y : 1965
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0920Bean {
            /**
             * V : 国际爱牙日
             * P : 2
             * Y : 1989
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0518Bean {
            /**
             * V : 博物馆日
             * P : 6
             * Y : 1977
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0702Bean {
            /**
             * V : 国际体育记者日
             * P : 2
             * Y : 1995
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0323Bean {
            /**
             * V : 世界气象日
             * P : 2
             * Y : 1950
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0312Bean {
            /**
             * V : 孙中山逝世纪念日
             * P : 2
             * Y : 1925
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0301Bean {
            /**
             * V : 国际海豹日
             * P : 2
             * Y : 1983
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0324Bean {
            /**
             * V : 世界防治结核病日
             * P : 2
             * Y : 1995
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0508Bean {
            /**
             * V : 世界红十字日
             * P : 2
             * Y : 1948
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0531Bean {
            /**
             * V : 世界无烟日
             * P : 6
             * Y : 1989
             * L : 无烟日
             */

            private String V;
            private String P;
            private String Y;
            private String L;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }

            public String getL() {
                return L;
            }

            public void setL(String L) {
                this.L = L;
            }
        }

        public static class _$0623Bean {
            /**
             * V : 奥林匹克
             * P : 6
             * Y : 1948
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0210Bean {
            /**
             * V : 国际气象节
             * P : 2
             * Y : 1991
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0407Bean {
            /**
             * V : 世界卫生日
             * P : 2
             * Y : 1948
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0626Bean {
            /**
             * V : 国际禁毒日
             * P : 2
             * Y : 1987
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0903Bean {
            /**
             * V : 抗日战争胜利纪念日
             * P : 6
             * Y : 1945
             * L : 抗战胜利
             */

            private String V;
            private String P;
            private String Y;
            private String L;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }

            public String getL() {
                return L;
            }

            public void setL(String L) {
                this.L = L;
            }
        }

        public static class _$0730Bean {
            /**
             * V : 非洲妇女日
             * P : 2
             * Y : 1997
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0512Bean {
            /**
             * V : 国际护士节
             * P : 6
             * Y : 1912
             * L : 护士节
             */

            private String V;
            private String P;
            private String Y;
            private String L;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }

            public String getL() {
                return L;
            }

            public void setL(String L) {
                this.L = L;
            }
        }

        public static class _$0914Bean {
            /**
             * V : 世界清洁地球日
             * P : 2
             * Y : 2006
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0202Bean {
            /**
             * V : 世界湿地日
             * P : 6
             * Y : 1997
             * L : 湿地日
             */

            private String V;
            private String P;
            private String Y;
            private String L;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }

            public String getL() {
                return L;
            }

            public void setL(String L) {
                this.L = L;
            }
        }

        public static class _$0501Bean {
            /**
             * V : 劳动节
             * P : 10
             * Y : 1912
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0214Bean {
            /**
             * V : 情人节
             * P : 9
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0910Bean {
            /**
             * V : 教师节
             * P : 9
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0404Bean {
            /**
             * V : 儿童节
             * P : 6
             * Y : 1931
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0605Bean {
            /**
             * V : 世界环境保护日
             * P : 6
             * Y : 1972
             * L : 环保日
             */

            private String V;
            private String P;
            private String Y;
            private String L;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }

            public String getL() {
                return L;
            }

            public void setL(String L) {
                this.L = L;
            }
        }
    }

    public static class LBean {
        @SerializedName("1208")
        private List<_$1208Bean> _$1208;
        @SerializedName("1216")
        private List<_$1216Bean> _$1216;
        @SerializedName("1223")
        private List<_$1223Bean> _$1223;
        @SerializedName("1224")
        private List<_$1224BeanX> _$1224;
        @SerializedName("1230")
        private List<_$1230Bean> _$1230;
        @SerializedName("0303")
        private List<_$0303Bean> _$0303;
        @SerializedName("0202")
        private List<_$0202BeanX> _$0202;
        @SerializedName("0707")
        private List<_$0707Bean> _$0707;
        @SerializedName("0505")
        private List<_$0505Bean> _$0505;
        @SerializedName("0815")
        private List<_$0815BeanX> _$0815;
        @SerializedName("0909")
        private List<_$0909Bean> _$0909;
        @SerializedName("0101")
        private List<_$0101BeanX> _$0101;
        @SerializedName("0715")
        private List<_$0715Bean> _$0715;
        @SerializedName("0115")
        private List<_$0115Bean> _$0115;
        @SerializedName("0408")
        private List<_$0408BeanX> _$0408;

        public List<_$1208Bean> get_$1208() {
            return _$1208;
        }

        public void set_$1208(List<_$1208Bean> _$1208) {
            this._$1208 = _$1208;
        }

        public List<_$1216Bean> get_$1216() {
            return _$1216;
        }

        public void set_$1216(List<_$1216Bean> _$1216) {
            this._$1216 = _$1216;
        }

        public List<_$1223Bean> get_$1223() {
            return _$1223;
        }

        public void set_$1223(List<_$1223Bean> _$1223) {
            this._$1223 = _$1223;
        }

        public List<_$1224BeanX> get_$1224() {
            return _$1224;
        }

        public void set_$1224(List<_$1224BeanX> _$1224) {
            this._$1224 = _$1224;
        }

        public List<_$1230Bean> get_$1230() {
            return _$1230;
        }

        public void set_$1230(List<_$1230Bean> _$1230) {
            this._$1230 = _$1230;
        }

        public List<_$0303Bean> get_$0303() {
            return _$0303;
        }

        public void set_$0303(List<_$0303Bean> _$0303) {
            this._$0303 = _$0303;
        }

        public List<_$0202BeanX> get_$0202() {
            return _$0202;
        }

        public void set_$0202(List<_$0202BeanX> _$0202) {
            this._$0202 = _$0202;
        }

        public List<_$0707Bean> get_$0707() {
            return _$0707;
        }

        public void set_$0707(List<_$0707Bean> _$0707) {
            this._$0707 = _$0707;
        }

        public List<_$0505Bean> get_$0505() {
            return _$0505;
        }

        public void set_$0505(List<_$0505Bean> _$0505) {
            this._$0505 = _$0505;
        }

        public List<_$0815BeanX> get_$0815() {
            return _$0815;
        }

        public void set_$0815(List<_$0815BeanX> _$0815) {
            this._$0815 = _$0815;
        }

        public List<_$0909Bean> get_$0909() {
            return _$0909;
        }

        public void set_$0909(List<_$0909Bean> _$0909) {
            this._$0909 = _$0909;
        }

        public List<_$0101BeanX> get_$0101() {
            return _$0101;
        }

        public void set_$0101(List<_$0101BeanX> _$0101) {
            this._$0101 = _$0101;
        }

        public List<_$0715Bean> get_$0715() {
            return _$0715;
        }

        public void set_$0715(List<_$0715Bean> _$0715) {
            this._$0715 = _$0715;
        }

        public List<_$0115Bean> get_$0115() {
            return _$0115;
        }

        public void set_$0115(List<_$0115Bean> _$0115) {
            this._$0115 = _$0115;
        }

        public List<_$0408BeanX> get_$0408() {
            return _$0408;
        }

        public void set_$0408(List<_$0408BeanX> _$0408) {
            this._$0408 = _$0408;
        }

        public static class _$1208Bean {
            /**
             * V : 腊八节
             * P : 9
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1216Bean {
            /**
             * V : 尾牙
             * P : 6
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1223Bean {
            /**
             * V : 小年
             * P : 9
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1224BeanX {
            /**
             * V : 祭灶
             * P : 9
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1230Bean {
            /**
             * V : 除夕夜
             * P : 10
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0303Bean {
            /**
             * V : 上巳节
             * P : 6
             * Y : 1900
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0202BeanX {
            /**
             * V : 龙抬头
             * P : 9
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0707Bean {
            /**
             * V : 七夕节
             * P : 9
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0505Bean {
            /**
             * V : 端午节
             * P : 10
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0815BeanX {
            /**
             * V : 中秋节
             * P : 10
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0909Bean {
            /**
             * V : 重阳节
             * P : 10
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0101BeanX {
            /**
             * V : 春节
             * P : 10
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0715Bean {
            /**
             * V : 盂兰盆节
             * P : 9
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0115Bean {
            /**
             * V : 元宵节
             * P : 9
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0408BeanX {
            /**
             * V : 佛陀诞辰
             * P : 10
             * Y : 1899
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }
    }

    public static class WBean {
        @SerializedName("1011")
        private List<_$1011BeanX> _$1011;
        @SerializedName("1013")
        private List<_$1013BeanX> _$1013;
        @SerializedName("1024")
        private List<_$1024BeanX> _$1024;
        @SerializedName("1144")
        private List<_$1144Bean> _$1144;
        @SerializedName("1220")
        private List<_$1220Bean> _$1220;
        @SerializedName("0730")
        private List<_$0730BeanX> _$0730;
        @SerializedName("0630")
        private List<_$0630Bean> _$0630;
        @SerializedName("0520")
        private List<_$0520BeanX> _$0520;
        @SerializedName("0150")
        private List<_$0150Bean> _$0150;
        @SerializedName("0940")
        private List<_$0940Bean> _$0940;
        @SerializedName("0950")
        private List<_$0950Bean> _$0950;

        public List<_$1011BeanX> get_$1011() {
            return _$1011;
        }

        public void set_$1011(List<_$1011BeanX> _$1011) {
            this._$1011 = _$1011;
        }

        public List<_$1013BeanX> get_$1013() {
            return _$1013;
        }

        public void set_$1013(List<_$1013BeanX> _$1013) {
            this._$1013 = _$1013;
        }

        public List<_$1024BeanX> get_$1024() {
            return _$1024;
        }

        public void set_$1024(List<_$1024BeanX> _$1024) {
            this._$1024 = _$1024;
        }

        public List<_$1144Bean> get_$1144() {
            return _$1144;
        }

        public void set_$1144(List<_$1144Bean> _$1144) {
            this._$1144 = _$1144;
        }

        public List<_$1220Bean> get_$1220() {
            return _$1220;
        }

        public void set_$1220(List<_$1220Bean> _$1220) {
            this._$1220 = _$1220;
        }

        public List<_$0730BeanX> get_$0730() {
            return _$0730;
        }

        public void set_$0730(List<_$0730BeanX> _$0730) {
            this._$0730 = _$0730;
        }

        public List<_$0630Bean> get_$0630() {
            return _$0630;
        }

        public void set_$0630(List<_$0630Bean> _$0630) {
            this._$0630 = _$0630;
        }

        public List<_$0520BeanX> get_$0520() {
            return _$0520;
        }

        public void set_$0520(List<_$0520BeanX> _$0520) {
            this._$0520 = _$0520;
        }

        public List<_$0150Bean> get_$0150() {
            return _$0150;
        }

        public void set_$0150(List<_$0150Bean> _$0150) {
            this._$0150 = _$0150;
        }

        public List<_$0940Bean> get_$0940() {
            return _$0940;
        }

        public void set_$0940(List<_$0940Bean> _$0940) {
            this._$0940 = _$0940;
        }

        public List<_$0950Bean> get_$0950() {
            return _$0950;
        }

        public void set_$0950(List<_$0950Bean> _$0950) {
            this._$0950 = _$0950;
        }

        public static class _$1011BeanX {
            /**
             * V : 国际住房日
             * P : 2
             * Y : 1985
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1013BeanX {
            /**
             * V : 国际减轻自然灾害日
             * P : 2
             * Y : 1987
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1024BeanX {
            /**
             * V : 世界视觉日
             * P : 2
             * Y : 2000
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1144Bean {
            /**
             * V : 感恩节
             * P : 9
             * Y : 1941
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$1220Bean {
            /**
             * V : 国际儿童电视广播日
             * P : 2
             * Y : 1985
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0730BeanX {
            /**
             * V : 被奴役国家周
             * P : 2
             * Y : 1959
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0630Bean {
            /**
             * V : 父亲节
             * P : 9
             * Y : 2005
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0520BeanX {
            /**
             * V : 母亲节
             * P : 9
             * Y : 1876
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0150Bean {
            /**
             * V : 国际麻风节
             * P : 2
             * Y : 1953
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0940Bean {
            /**
             * V : 国际聋人节
             * P : 2
             * Y : 1958
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }

        public static class _$0950Bean {
            /**
             * V : 世界心脏日
             * P : 2
             * Y : 1978
             */

            private String V;
            private String P;
            private String Y;

            public String getV() {
                return V;
            }

            public void setV(String V) {
                this.V = V;
            }

            public String getP() {
                return P;
            }

            public void setP(String P) {
                this.P = P;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }
        }
    }
}
