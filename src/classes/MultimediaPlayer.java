package classes;

import java.util.Scanner;

import abstract_classes.MultimediaElement;

public class MultimediaPlayer {
	private static MultimediaElement[] multimediaElements = new MultimediaElement[5];
	private static int index = 0;

	public static void main(String[] args) {
		playerStart();
	}

	public static void playerStart() {

		System.out.println("####### Andrea's Media Player #######");
		System.out.println();
		System.out.println("Please select one of the options below:");
		Scanner actionsScanner = new Scanner(System.in);
		System.out.println("1 - ADD MEDIA");
		System.out.println("2 - PLAY/SHOW MEDIA");
		System.out.println();
		int selectedAction = actionsScanner.nextInt();

		if (selectedAction == 1) {
			System.out.println("#####################################");
			System.out.println();
			System.out.println("What kind of media you want to add? ");
			System.out.println("0 - GO BACK");
			System.out.println("1 - AUDIO");
			System.out.println("2 - IMAGE");
			System.out.println("3 - VIDEO");
			int media = actionsScanner.nextInt();

			switch (media) {
			case 1: {
				System.out.println("#####################################");
				Scanner audioScanner = new Scanner(System.in);
				System.out.println("Please insert a title for the Audio: ");
				String title = audioScanner.nextLine();
				System.out.println("Please insert a duration: ");
				int duration = audioScanner.nextInt();
				System.out.println(title + " " + duration);
				Audio audio = new Audio(title, duration);
				multimediaElements[index] = audio;
				index++;
				playerStart();
				break;
			}
			case 2: {
				Scanner imageScanner = new Scanner(System.in);
				System.out.println("Please insert a title for the Image: ");
				String title = imageScanner.nextLine();
				System.out.println(title);
				Image image = new Image(title);
				multimediaElements[index] = image;
				index++;
				playerStart();
				break;
			}
			case 3: {
				Scanner videoScanner = new Scanner(System.in);
				System.out.println("Please insert a title for the Video: ");
				String title = videoScanner.nextLine();
				System.out.println("Please insert a duration: ");
				int duration = videoScanner.nextInt();
				System.out.println(title + " " + duration);
				Video video = new Video(title, duration);
				multimediaElements[index] = video;
				index++;
				playerStart();
				break;
			}
			default: {
				System.out.println("Please select a valid media");
				playerStart();
				break;
			}
			}
		} else if (selectedAction == 2) {
			Scanner scanner = new Scanner(System.in);
			int x = 0;
			for (int i = 0; i < index; i++) {
				x++;
				System.out.println(x + " " + multimediaElements[i]);
			}

			System.out.println("Plase select a media: ");
			int sceltaMedia = scanner.nextInt();
			switch (sceltaMedia) {
			case 0:
				playerStart();
				break;
			case 1:
				playerControls(multimediaElements[0]);
				break;
			case 2:
				playerControls(multimediaElements[1]);
				break;
			case 3:
				playerControls(multimediaElements[2]);
				break;
			case 4:
				playerControls(multimediaElements[3]);
				break;
			case 5:
				playerControls(multimediaElements[4]);
				break;
			}
		} else {
			System.out.println("Please select a valid entry");
			playerStart();

		}
	}

	public static void playerControls(MultimediaElement multimediaElements) {

		if (multimediaElements instanceof Audio) {

			Scanner scanner = new Scanner(System.in);
			System.out.println("0 - GO BACK");
			System.out.println("1 - PLAY");
			System.out.println("2 - VOLUME UP");
			System.out.println("3 - VOLUME DOWN");
			System.out.println();
			System.out.println("Volume: " + ((Audio) multimediaElements).volume);
			int selectedAction = scanner.nextInt();

			switch (selectedAction) {
			case 1:
				((Audio) multimediaElements).play();
				break;
			case 2:
				((Audio) multimediaElements).volumeUp();
				playerControls(multimediaElements);
				break;
			case 3:
				((Audio) multimediaElements).volumeDown();
				playerControls(multimediaElements);
				break;
			default:
				System.out.println("Please select a valid entry");
				playerControls(multimediaElements);
				break;
			}
		} else if (multimediaElements instanceof Video)

		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("0 - GO BACK");
			System.out.println("1 - PLAY");
			System.out.println("2 - VOLUME UP");
			System.out.println("3 - VOLUME DOWN");
			System.out.println("4 - BRIGHTNESS UP");
			System.out.println("5 - BRIGHTNESS DOWN");
			System.out.println();
			System.out.println("Volume: " + ((Video) multimediaElements).volume);
			System.out.println("Brightness: " + ((Video) multimediaElements).brightness);
			int selectedAction = scanner.nextInt();
			switch (selectedAction) {
			case 1:
				((Video) multimediaElements).play();
				break;
			case 2:
				((Video) multimediaElements).volumeUp();
				playerControls(multimediaElements);
				break;
			case 3:
				((Video) multimediaElements).volumeDown();
				playerControls(multimediaElements);
				break;
			case 4:
				((Video) multimediaElements).brightnessUp();
				playerControls(multimediaElements);
				break;
			case 5:
				((Video) multimediaElements).brightnessDown();
				playerControls(multimediaElements);
				break;
			default:
				System.out.println("Please select a valid entry");
				playerControls(multimediaElements);
				break;
			}

		} else if (multimediaElements instanceof Image) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("0 - GO BACK");
			System.out.println("1 - SHOW");
			System.out.println("2 - BRIGHTNESS UP");
			System.out.println("3 - BRIGHTNESS DOWN");
			System.out.println();
			System.out.println("Brightness: " + ((Image) multimediaElements).brightness);
			int selectedAction = scanner.nextInt();
			switch (selectedAction) {
			case 1:
				((Image) multimediaElements).show();
				break;
			case 2:
				((Image) multimediaElements).brightnessUp();
				playerControls(multimediaElements);
				break;
			case 3:
				((Image) multimediaElements).brightnessDown();
				playerControls(multimediaElements);
				break;
			default:
				System.out.println("Please select a valid entry");
				playerControls(multimediaElements);
				break;
			}
		}

	}

}
