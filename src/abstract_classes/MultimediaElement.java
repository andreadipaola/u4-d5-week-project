package abstract_classes;

import classes.Audio;
import classes.Video;

public abstract class MultimediaElement {
	public String title;
	public int duration;
	public int volume = 5;
	public int brightness = 5;

	public MultimediaElement(String title) {
		this.title = title;
	}

	public MultimediaElement(String title, int duration) {
		this.title = title;
		this.duration = duration;
	}

	public void play() {

		if (MultimediaElement.this instanceof Audio) {
			System.out.println("Audio Playing");
			for (int i = 0; i < this.duration; i++) {
				String volumeNTimes = "";
				for (int j = this.volume; j > 0; j--) {
					volumeNTimes += " !";
				}
				System.out.println(i + "\t" + this.title.toUpperCase() + volumeNTimes);
			}
		} else if (MultimediaElement.this instanceof Video) {
			System.out.println("Video Playing");
			for (int i = 0; i < this.duration; i++) {
				String brightnessNTimes = "";
				String volumeNTimes = "";
				for (int j = this.volume; j > 0; j--) {
					volumeNTimes += " !";
				}
				for (int k = this.brightness; k > 0; k--) {
					brightnessNTimes += " *";
				}
				System.out.println(i + "\t" + this.title.toUpperCase() + volumeNTimes + brightnessNTimes);
			}
		} else {
			show();
		}

	}

	public void show() {

		String brightnessNTimes = "";
		for (int k = this.brightness; k > 0; k--) {
			brightnessNTimes += " *";
		}
		System.out.println("Image Showing");
		System.out.println(this.title + brightnessNTimes);
	}

}
