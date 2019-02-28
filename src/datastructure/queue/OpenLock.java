package datastructure.queue;

import java.util.*;

/**
 * @author xuyong
 * @since 2019-02-27 11:50
 **/
public class OpenLock {

    public int openLock(String[] deadends, String target) {
        String result = "0000";
        Map<String, Integer> hashMap = new HashMap<>(10000);


        Queue<String> queue = new LinkedList<>();
        queue.offer(result);

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                result = queue.peek();
                if (result.equals(target)) {
                    return step;
                }
                dfs(queue, result, deadends, hashMap);
                queue.poll();
            }
            step++;
        }
        return -1;
    }

    private void dfs(Queue<String> queue, String result, String[] deadends, Map<String, Integer> hashMap) {
        char[] chars = result.toCharArray();
        if (hashMap.get(result) != null) {
            return;
        }
        if (deadends != null && deadends.length > 0) {
            for (String deadend : deadends) {
                if (result.equals(deadend)) {
                    return;
                }
            }
        }
        hashMap.put(result, 1);

        queue.offer(String.valueOf(new char[]{chars[0] + 1 > '9' ? '0' : (char) (chars[0] + 1), chars[1], chars[2], chars[3]}));
        queue.offer(String.valueOf(new char[]{chars[0] - 1 < '0' ? '9' : (char) (chars[0] - 1), chars[1], chars[2], chars[3]}));
        queue.offer(String.valueOf(new char[]{chars[0], chars[1] + 1 > '9' ? '0' : (char) (chars[1] + 1), chars[2], chars[3]}));
        queue.offer(String.valueOf(new char[]{chars[0], chars[1] - 1 < '0' ? '9' : (char) (chars[1] - 1), chars[2], chars[3]}));
        queue.offer(String.valueOf(new char[]{chars[0], chars[1], chars[2] + 1 > '9' ? '0' : (char) (chars[2] + 1), chars[3]}));
        queue.offer(String.valueOf(new char[]{chars[0], chars[1], chars[2] - 1 < '0' ? '9' : (char) (chars[2] - 1), chars[3]}));
        queue.offer(String.valueOf(new char[]{chars[0], chars[1], chars[2], chars[3] + 1 > '9' ? '0' : (char) (chars[3] + 1)}));
        queue.offer(String.valueOf(new char[]{chars[0], chars[1], chars[2], chars[3] - 1 < '0' ? '9' : (char) (chars[3] - 1)}));
    }

    public static void main(String[] args) {
        System.out.println(new OpenLock().openLock(new String[]{"8430", "5911", "4486", "7174", "9772", "0731", "9550", "3449", "4437", "3837", "1870", "5798", "9583", "9512", "5686", "5131", "0736", "3051", "2141", "2989", "6368", "2004", "1012", "8736", "0363", "3589", "8568", "6457", "3467", "1967", "1055", "6637", "1951", "0575", "4603", "2606", "0710", "4169", "7009", "6554", "6128", "2876", "8151", "4423", "0727", "8130", "3571", "4801", "8968", "6084", "3156", "3087", "0594", "9811", "3902", "4690", "6468", "2743", "8560", "9064", "4231", "6056", "2551", "8556", "2541", "5460", "5657", "1151", "5123", "3521", "2200", "9333", "9685", "4871", "9138", "5807", "2191", "2601", "1792", "3470", "9096", "0185", "0367", "6862", "1757", "6904", "4485", "7973", "7201", "2571", "3829", "0868", "4632", "6975", "2026", "3463", "2341", "4647", "3680", "3282", "3761", "4410", "3397", "3357", "4038", "6505", "1655", "3812", "3558", "4759", "1112", "8836", "5348", "9113", "1627", "3249", "0537", "4227", "7952", "8855", "3592", "2054", "3175", "6665", "4088", "9959", "3809", "7379", "6949", "8063", "3686", "8078", "0925", "5167", "2075", "4665", "2628", "8242", "9831", "1397", "5547", "9449", "6512", "6083", "9682", "2215", "3236", "2457", "6211", "5536", "8674", "2647", "9752", "5433", "0186", "5904", "1526", "5347", "1387", "3153", "1353", "6069", "9995", "9496", "0003", "3400", "1692", "6870", "4445", "3063", "0708", "3278", "6961", "3063", "0249", "0375", "1763", "1804", "4695", "6493", "7573", "9977", "1108", "0856", "5631", "4799", "4164", "0844", "2600", "1785", "1587", "4510", "9012", "7497", "4923", "2560", "0338", "3839", "5624", "1980", "1514", "4634", "2855", "7012", "3626", "7032", "6145", "5663", "4395", "0724", "4711", "1573", "6904", "8100", "2649", "3890", "8110", "8067", "1460", "0186", "6098", "2459", "6991", "9372", "8539", "8418", "7944", "0499", "9276", "1525", "1281", "8738", "5054", "7869", "6599", "8018", "7530", "2327", "3681", "5248", "4291", "7300", "8854", "2591", "8744", "3052", "6369", "3669", "8501", "8455", "5726", "1211", "8793", "6889", "9315", "0738", "6805", "5980", "7485", "2333", "0140", "4708", "9558", "9026", "4349", "5978", "4989", "5238", "3217", "5938", "9660", "5858", "2118", "7657", "5896", "3195", "8997", "1688", "2863", "9356", "4208", "5438", "2642", "4138", "7466", "6154", "0926", "2556", "9574", "4497", "9633", "0585", "1390", "5093", "3047", "0430", "7482", "0750", "6229", "8714", "4765", "0941", "1780", "6262", "0925", "5631", "9167", "0885", "7713", "5576", "3775", "9652", "0733", "7467", "5301", "9365", "7978", "4736", "3309", "6965", "4703", "5897", "8460", "9619", "0572", "6297", "7701", "7554", "8669", "5426", "6474", "5540", "5038", "3880", "1657", "7574", "1108", "4369", "7782", "9742", "5301", "6984", "3158", "2869", "0599", "2147", "6962", "9722", "3597", "9015", "3115", "9051", "8269", "6967", "5392", "4401", "6579", "8997", "8933", "9297", "0151", "8820", "3297", "6723", "1755", "1163", "8896", "7122", "4859", "5504", "0857", "4682", "8177", "8702", "9167", "9410", "0130", "2789", "7492", "5938", "3012", "4137", "3414", "2245", "4292", "6945", "5446", "6614", "2977", "8640", "9242", "7603", "8349", "9420", "0538", "4222", "0599", "8459", "8738", "4764", "6717", "7575", "5965", "9816", "9975", "4994", "2612", "0344", "6450", "9088", "4898", "6379", "4127", "1574", "9044", "0434", "5928", "6679", "1753", "8940", "7563", "0545", "4575", "6407", "6213", "8327", "3978", "9187", "2996", "1956", "8819", "9591", "7802", "4747", "9094", "0179", "0806", "2509", "4026", "4850", "2495", "3945", "4994", "5971", "3401", "0218", "6584", "7688", "6138", "7047", "9456", "0173", "1406", "1564", "3055", "8725", "4835", "4737", "6279", "5291", "0145", "0002", "1263", "9518", "1251", "8224", "6779", "4113", "8680", "2946", "1685", "2057", "9520", "4099", "7785", "1134", "2152", "4719", "6038", "1599", "6750", "9273", "7755", "3134", "2345", "8208", "5750", "5850", "2019", "0350", "9013", "6911", "6095", "6843", "3157", "9049", "0801", "2739", "9691", "3511"}, "2248"));

    }

}
