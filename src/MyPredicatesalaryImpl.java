
public class MyPredicatesalaryImpl implements MyPredicate<Entity>{

	@Override
	public boolean test(Entity entity) {
		return entity.getSalary()>200;
	}



}
