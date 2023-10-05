public class Main {
    public static void main(String[] args) {
        if(args[0].equals("help")){
            System.out.println("---Справка по использованию генератора мемов---");
            System.out.println("Использование: meme <название файла> <" + '"' + "текст мема" + '"' + "> <ключи дополнительных настроек и их значения>");
            System.out.println("---Ключи настроек и их использование---");
            System.out.println("Ключи могут быть использованы в любом порядке и в любых комбинациях, либо не использоватья.");
            System.out.println("-size <целое число>: изменить размер шрифта. По умолчанию: 40");
            System.out.println("-position <bottom|top|center>: расположить надпись в заданной части изображения. По умолчанию: bottom");
            System.out.println("-shadow <y|n>: Включение и отключение создания тени для надписи. По умолчанию: y (включено)");
            System.out.println("---Выходной файл---");
            System.out.println("Файл с созданным мемом появится в той же директории.");
            System.out.println("Название сгенерированного файла: " + '"' + "meme-<название исходного файла>" + '"');
            System.out.println("---Пример команды для генерации---");
            System.out.println("meme test.jpg \"When you realize you're a cat\" -size 50 -position bottom -shadow y");
        } else if(args[0].equals("meme")){
            Generator.generateMeme(new GeneratorSettings(args));
        } else{
            System.out.println("Ошибка: неизвестный параметр на первой позиции.");
            System.exit(1);
        }
    }
}