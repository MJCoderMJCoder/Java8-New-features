
public class MyPredicateImpl implements MyPredicate<Entity>{

	@Override
	public boolean test(Entity entity) {
		return entity.getAgel()>13;
	}


}
