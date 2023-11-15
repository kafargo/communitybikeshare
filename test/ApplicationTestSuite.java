import org.bikeshare.model.business.AllBusinessTests;
import org.bikeshare.model.domain.AllDomainTests;
import org.bikeshare.model.services.AllServicesTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;




@RunWith(Suite.class)
@SuiteClasses({AllDomainTests.class, AllServicesTests.class, AllBusinessTests.class})
public class ApplicationTestSuite {

}
