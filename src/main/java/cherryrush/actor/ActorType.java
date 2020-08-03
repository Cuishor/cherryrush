package cherryrush.actor;

public enum ActorType {
	MONSTER(".\\src\\main\\resources\\monster.png"),
	CHERRY(".\\src\\main\\resources\\cherry.png");
	
	private String aspect;
	
	ActorType(String aspect) {
		this.setAspect(aspect);
	}

	public String getAspect() {
		return aspect;
	}

	public void setAspect(String aspect) {
		this.aspect = aspect;
	}
	
}
