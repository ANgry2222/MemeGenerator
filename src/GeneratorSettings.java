public class GeneratorSettings {
    public enum Position{TOP, BOTTOM, CENTER};
    private int fontSize;
    private Boolean shadow;
    private Position textPosition;
    private String memeText;
    private String fileName;
    private String fileExtension;

    public int getFontSize() {
        return fontSize;
    }

    public Boolean getShadow() {
        return shadow;
    }

    public Position getTextPosition() {
        return textPosition;
    }

    public String getMemeText() {
        return memeText;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getFileName() {
        return fileName;
    }

    public GeneratorSettings(String[] args){
        this.fontSize = 40;
        this.textPosition = Position.BOTTOM;
        this.shadow = true;

        sortOutArgsList(args);
    }

    private void sortOutArgsList(String[] args){
        if(args.length < 3){
            System.out.println("Ошибка: передано неверное число параметров - минимум 3.");
            System.exit(1);
        } else if(args.length % 2 == 0){
            System.out.println("Ошибка: неверное использование параметров. Воспользуйтесь справкой.");
            System.exit(1);
        } else if(args.length > 9){
            System.out.println("Ошибка: передано неверное число параметров - максимум 9.");
            System.exit(1);
        }

        this.fileName = args[1];
        this.fileExtension = args[1].split("\\.")[1];
        this.memeText = args[2];

        for(int i = 0; i < (args.length - 3) / 2; i++){
            if((args[3 + 2 * i]).equals("-shadow")){
                if(args[3 + 2 * i + 1].equals("y")){
                    this.shadow = true;
                } else if(args[3 + 2 * i + 1].equals("n")){
                    this.shadow = false;
                }
            } else if((args[3 + 2 * i]).equals("-position")){
                if(args[3 + 2 * i + 1].equals("top")){
                    this.textPosition = Position.TOP;
                } else if(args[3 + 2 * i + 1].equals("bottom")){
                    this.textPosition = Position.BOTTOM;
                } else if(args[3 + 2 * i + 1].equals("center")){
                    this.textPosition = Position.CENTER;
                }
            } else if((args[3 + 2 * i]).equals("-size")){
                this.fontSize = Integer.parseInt(args[3 + 2 * i + 1]);
            } else {
                System.out.println("Ошибка: обнаружен несуществующий ключ.");
                System.exit(1);
            }
        }
    }
}
