package validation;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Site;

public class ValidateSiteTest {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void invalidUrlSite() {
		Site site = new Site("xxxxxx");
		Set<ConstraintViolation<Site>> constraintViolations = validator.validate(site);
		assertEquals("must be a valid URL", constraintViolations.iterator().next().getMessage());
		

	}

	@Test
	public void validUrl() {
		Site site = new Site("http://google.com");
		Set<ConstraintViolation<Site>> constraintViolations = validator.validate(site);
		assertEquals(0, constraintViolations.size());

	}

}
