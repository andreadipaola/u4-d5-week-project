package classes;

import abstract_classes.MultimediaElement;
import interfaces.IBrightness;
import interfaces.IVolume;

public class Video extends MultimediaElement implements IVolume, IBrightness {
	public Video(String title, int duration) {
		super(title, duration);
	}

	@Override
	public int volumeUp() {
		return volume < 10 ? volume++ : volume;
	}

	@Override
	public int volumeDown() {
		return volume > 0 ? volume-- : volume;
	}

	@Override
	public int brightnessUp() {
		return brightness < 10 ? brightness++ : brightness;
	}

	@Override
	public int brightnessDown() {
		return brightness > 0 ? brightness-- : brightness;
	}

	@Override
	public String toString() {
		return "- " + this.title + " - " + this.duration + "sec (video)";
	}

}
