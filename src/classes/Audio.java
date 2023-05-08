package classes;

import abstract_classes.MultimediaElement;
import interfaces.IVolume;

public class Audio extends MultimediaElement implements IVolume {

	public Audio(String title, int duration) {
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
	public String toString() {
		return "- " + this.title + " - " + this.duration + "sec (audio)";
	}

}
