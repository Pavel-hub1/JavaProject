package packeges;

public class Validate {

    public void checkNumber(String telephone) throws Exception {
        if(!telephone.substring(0,1).equals("+")) {
            throw new Telephone("Номер начинается с плюса +");
        }

        else if(telephone.length() != 12) {
            throw new Telephone("Длина телефона должна быть 11");
        }
    }
}