package singleton.postCode;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        PostCodeService postCodeService = PostCodeServiceEnum.INSTANCE;

        List<PostCode> codes = postCodeService.getPostCodes(new City("Baku"));
        PostCode code = postCodeService.getPostCode(new City("Baku"), new Street("8 November"));

        System.out.println(codes);
        System.out.println();
        System.out.println(code);
    }
}
