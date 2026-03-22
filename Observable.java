public interface Observable<T> {
	public abstract void addObserver(Observer<T> observer);

	public abstract void removeObserver(Observer<T> observer);

	public abstract void notifyObservers(T event);
}
