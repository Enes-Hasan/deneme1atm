import java.util.Scanner;




    public class ATM {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int balance = 1000;
            int pin = 1907;
            int attempts = 3;

            System.out.println(" ATM'ye Hoş Geldiniz!");


            while (attempts > 0) {
                System.out.print("Lütfen 4 haneli PIN kodunuzu girin: ");
                int enteredPin = scanner.nextInt();

                if (enteredPin == pin) {
                    System.out.println(" Giriş başarılı!");


                    while (true) {
                        System.out.println("\n Menü:");
                        System.out.println("1️ Bakiye Görüntüleme");
                        System.out.println("2️ Para Yatırma");
                        System.out.println("3️ Para Çekme");
                        System.out.println("4️ Çıkış");
                        System.out.print("Lütfen yapmak istediğiniz işlemi seçin: ");

                        int choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                System.out.println(" Güncel bakiyeniz: " + balance + " TL");
                                break;
                            case 2:
                                System.out.print(" Yatırılacak miktarı girin: ");
                                int deposit = scanner.nextInt();
                                if (deposit > 0) {
                                    balance += deposit;
                                    System.out.println(" Para yatırıldı. Yeni bakiyeniz: " + balance + " TL");
                                } else {
                                    System.out.println(" Geçersiz miktar! Pozitif bir değer girin.");
                                }
                                break;
                            case 3:
                                System.out.print("📤 Çekmek istediğiniz miktarı girin: ");
                                int withdraw = scanner.nextInt();
                                if (withdraw > 0 && withdraw <= balance) {
                                    balance -= withdraw;
                                    System.out.println(" Para çekildi. Yeni bakiyeniz: " + balance + " TL");
                                } else {
                                    System.out.println(" Yetersiz bakiye veya geçersiz miktar!");
                                }
                                break;
                            case 4:
                                System.out.println(" Çıkış yapılıyor... Teşekkür ederiz!");
                                scanner.close();
                                return;
                            default:
                                System.out.println("⚠ Geçersiz seçim! Lütfen 1-4 arasında bir sayı girin.");
                        }
                    }
                } else {
                    attempts--;
                    System.out.println(" Yanlış PIN! Kalan deneme hakkı: " + attempts);
                    if (attempts == 0) {
                        System.out.println(" 3 kez yanlış girdiniz! Hesabınız bloke oldu.");
                    }
                }
            }
            scanner.close();
        }
    }


