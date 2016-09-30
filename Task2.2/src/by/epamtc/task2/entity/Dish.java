package by.epamtc.task2.entity;

public class Dish {
	private String id;
	private String photo;
	private String name;
	private String description;
	private String portion;
	private int price;
	
	
	@Override
	public String toString() {
		return "Dish [id=" + id + ", photo=" + photo + ", name=" + name + ", description=" + description + ", portion="
				+ portion + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((portion == null) ? 0 : portion.hashCode());
		result = prime * result + price;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		Dish other = (Dish) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description)){
			return false;
		}
		if (id == null) {
			if (other.id != null){
				return false;
			}
		} else if (!id.equals(other.id)){
			return false;
		}
		if (name == null) {
			if (other.name != null){
				return false;
			}
		} else if (!name.equals(other.name)){
			return false;
		}
		if (photo == null) {
			if (other.photo != null){
				return false;
			}
		} else if (!photo.equals(other.photo)){
			return false;
		}
		if (portion == null) {
			if (other.portion != null){
				return false;
			}
		} else if (!portion.equals(other.portion)){
			return false;
		}
		if (price != other.price){
			return false;
		}
		return true;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPortion() {
		return portion;
	}
	public void setPortion(String portion) {
		this.portion = portion;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
