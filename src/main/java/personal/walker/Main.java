package personal.walker;

import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.DecoderException;
import personal.walker.array.LC6396;
import personal.walker.array.LC6430;
import personal.walker.dijktra.LC6343;
import personal.walker.dp.LC6449;
import personal.walker.matrix.LC6472;
import personal.walker.sliding.window.LC6329;
import personal.walker.sliding.window.LC6390;
import personal.walker.sliding.window.LC6425;
import personal.walker.string.LC6461;
import personal.walker.union.find.LC6432;

import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;


public class Main {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException, DecoderException, UnsupportedEncodingException {
        Solution lc = new LC6449();
        lc.runTestCases();
    }


    public static void solve() {
        BigDecimal N = new BigDecimal("179769313486231590772930519078902473361797697894230657273430081157732675805505620686985379449212982959585501387537164015710139858647833778606925583497541085196591615128057575940752635007475935288710823649949940771895617054361149474865046711015101563940680527540071584560878577663743040086340742855278549092581");

        MathContext mathCtx = new MathContext(200, RoundingMode.DOWN);
        BigDecimal A = new BigDecimal("13407807929942597099574024998205846127479365820592393377723561443721764030073720664935730272460038784167544890048265955830752343658005756322445518700544291");
        BigDecimal x = A.multiply(A).subtract(N).sqrt(mathCtx);
        System.out.println(x.toPlainString());
        BigDecimal q = A.subtract(x);
        System.out.println(q.toPlainString());
        BigDecimal p = A.add(x);
        System.out.println(p.toPlainString());
        // System.out.println(p.multiply(q).subtract(N).toPlainString());
    }


    public static void solve2() {
        BigDecimal N = new BigDecimal("648455842808071669662824265346772278726343720706976263060439070378797308618081116462714015276061417569195587321840254520655424906719892428844841839353281972988531310511738648965962582821502504990264452100885281673303711142296421027840289307657458645233683357077834689715838646088239640236866252211790085787877");

        MathContext mathCtx = new MathContext(200, RoundingMode.DOWN);
        System.out.println(N.sqrt(mathCtx).toPlainString());
        BigDecimal A = new BigDecimal("25464796146996183438008816563973942229341454268524157846328581927885777970045810444817548800110193810869973985549488954023184312335376930269142469838825504");
        for (long count = 0; count < 2 << 25; count++) {
            BigDecimal a = A.add(BigDecimal.valueOf(count));
            BigDecimal x = a.multiply(a).subtract(N).sqrt(mathCtx);
            BigDecimal q = a.subtract(x);
            BigDecimal p = a.add(x);
            if (q.multiply(p).subtract(N).compareTo(BigDecimal.ZERO) == 0) {
                System.out.println(q.toPlainString());
                break;
            }
        }

    }

    public static void solve3() {
        BigInteger N = new BigInteger("720062263747350425279564435525583738338084451473999841826653057981916355690188337790423408664187663938485175264994017897083524079135686877441155132015188279331812309091996246361896836573643119174094961348524639707885238799396839230364676670221627018353299443241192173812729276147530748597302192751375739387929");

        BigInteger N6 = N.multiply(BigInteger.valueOf(24));


        System.out.println(N6.sqrt());
        //  BigDecimal A = new BigDecimal("131459097554853198553643931189503735393893056560069574180596541504763272468756930205814940702782861638634577575123494197548004455659194920733082975077403789");
        BigInteger a = N6.subtract(BigInteger.ONE).sqrt().add(BigInteger.ONE);
        while (true) {
            a = a.add(BigInteger.ONE);
            BigInteger x = a.multiply(a).subtract(N6).sqrt();
            BigInteger q = a.subtract(x);

            if (N.mod(q.divide(BigInteger.valueOf(4))).compareTo(BigInteger.ZERO) == 0) {
                System.out.println(q);
            }
            if (N.mod(q.divide(BigInteger.valueOf(6))).compareTo(BigInteger.ZERO) == 0) {
                System.out.println(q);
            }
        }

    }

    static BigInteger gcd(BigInteger e, BigInteger z) {
        if (e.compareTo(BigInteger.ZERO) == 0)
            return z;
        else
            return gcd(z.remainder(e), e);
    }

    public static void solve4() throws UnsupportedEncodingException {
        BigInteger N = new BigInteger("179769313486231590772930519078902473361797697894230657273430081157732675805505620686985379449212982959585501387537164015710139858647833778606925583497541085196591615128057575940752635007475935288710823649949940771895617054361149474865046711015101563940680527540071584560878577663743040086340742855278549092581");

        BigInteger q = new BigInteger("13407807929942597099574024998205846127479365820592393377723561443721764030073662768891111614362326998675040546094339320838419523375986027530441562135724301");

        BigInteger p = N.divide(q);

        BigInteger r = (q.subtract(BigInteger.ONE)).multiply(p.subtract(BigInteger.ONE));

        BigInteger e = BigInteger.valueOf(65537);
        System.out.println(gcd(e, r));

        BigInteger d = e.modPow(BigInteger.valueOf(-1), r);
        ;

        System.out.println(d);
        BigInteger encryptMsg = new BigInteger("22096451867410381776306561134883418017410069787892831071731839143676135600120538004282329650473509424343946219751512256465839967942889460764542040581564748988013734864120452325229320176487916666402997509188729971690526083222067771600019329260870009579993724077458967773697817571267229951148662959627934791540");
        BigInteger msgBack = encryptMsg.modPow(d, N);

        String hexStr = msgBack.toString(16);
        System.out.println(msgBack.toByteArray()[0]);

        System.out.printf("len %d -> %s \n", hexStr.length(), hexStr);


        hexStr = "36cbf9d7a2ac2ccb0803fa564e5db15160acfb01ab519fa0c9a9ef7eea719233f4446c328dd736bad042145cd51f762671780816964f418a95d6a0e59df8be096a87d1bc3f45fc389ff3269fbdf4688079f0eab750f6e6d9eb4d5d4d40aac3";
        BigInteger msg = new BigInteger("36cbf9d7a2ac2ccb0803fa564e5db15160acfb01ab519fa0c9a9ef7eea719233f4446c328dd736bad042145cd51f762671780816964f418a95d6a0e59df8be096a87d1bc3f45fc389ff3269fbdf4688079f0eab750f6e6d9eb4d5d4d40aac3", 16);
        System.out.println(msg);
        System.out.println(new String(msg.toByteArray(), Charsets.US_ASCII));
        //System.out.println(Hex.decodeHex("0" + new BigDecimal(msgBack,16).toPlainString()));
    }

}



