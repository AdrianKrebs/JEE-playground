# JEE-playground

##Useful Links
* https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
* https://docs.oracle.com/javase/tutorial/extra/certification/javase-7-programmer2.html

List<Tester>testers = new ArrayList<>(Arrays.asList(new Tester("test",100),new Tester("test",50),new Tester("sefwese",60), new Tester("sdfdsf",60)));

        // customize your grouping by using key and then .mapping(attribute,collection))
        Map<Integer, List<String>> collect = testers.stream().collect(Collectors.groupingBy(Tester::getGrade, Collectors.mapping(Tester::getName, Collectors.toList())));
        System.out.println(collect);

        //testers.stream().map(Tester::getGrade).reduce((a,b) -> a+b);
       // testers.stream().map(Tester::getGrade).collect(Collectors.mapping());


        double totalAge = testers
                .stream()
                .mapToInt(Tester::getGrade)
                .average().getAsDouble();

        System.out.println(totalAge);

        // identity and accumulator
        Integer totalGradeReduce = testers
                .stream()
                .map(Tester::getGrade)
                .reduce(
                        0,
                        (a, b) -> a + b);

        System.out.println(totalGradeReduce);

        // https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
        // average with collect reduction --> mutable collection

        // supplier, accumulator, combiner

        Averager averageCollect = testers.stream()
                .filter(p -> p.getName().equals("test"))
                .map(Tester::getGrade)
                .collect(Averager::new, Averager::accept, Averager::combine);

        System.out.println("Average age of male members: " +
                averageCollect.average());
                
                
                  /*
     * ENUMS...again..
     */

    enum TesterEnum {
        WINTER("winter"), SPRING("spring"), SUMMER("summer"), FALL("fall");
        private String name;
        private static String TEST;

        // enum constructors cant acccess static varaibles due to initialization order -> consturctory -> static variables
        private TesterEnum(String name) {
            this.name = name;
            ;
        }

        public String getData() {
            return "test";
        }
    }

    public enum Pets {
        DOG(1, "D"), CAT(2, "C") {
            @Override
            public String getData() {
                return type + name;
            } // overriding is perfectly fine
        },
        FISH(3, "F");
        int type;
        String name;

        Pets(int t, String s) {
            this.name = s;
            this.type = t;
        }

        public String getData() {
            return name + type;
        }
    }

    public static void main(String[] args) throws IOException, SQLException {

        /*
         * VARIABLES BECOME FINAL IN TRY BLOCK
         */
        // initialized variables in try statements are final and can't be reassigned
        try (InputStream in = new FileInputStream(
                "C:\\ieu\\devspace\\devspace_3.1\\workspaces\\mcs-jeeservice\\mcs_systemtest\\src\\test\\java\\ch\\mobi\\mcs\\systemtest\\dunkelverarbeitungfacade\\test.txt");
                OutputStream out = new FileOutputStream("test.txt");) {

            //if (out == null) out = new FileOutputStream("default.txt");

        }

        /*
         * HOW TO AVOID NULLPOINTER WITH OPTIONALS
         */

        // Optional<Double> price = Optional.of(getPrice("1111")); // only one parameter
        Optional<Double> secondPrice = Optional.ofNullable(getPrice("1111"));
        Double y = secondPrice.orElseGet(() -> getPrice("333"));

        Optional<Double> thirdPrice = Optional.ofNullable(getPrice("1111"));
        Double x = thirdPrice.orElse(getPrice("2222"));
        System.out.println(x);

        /*
         * WORKING WITH NAVIGABLE SET / TREESET
         * 
         */

        TreeSet<Integer> s = new TreeSet<Integer>();
        TreeSet<Integer> subs = new TreeSet<Integer>();

        for (int i = 324; i <= 328; i++) {
            s.add(i);
        }
        subs = (TreeSet) s.subSet(326, true, 328, true); //from inlusive, to inclusive
        //        subs.add(329); // key out of range exception
        System.out.println(s + " " + subs);
        NavigableSet<Integer> naviSet = new TreeSet<>();
        Integer floor = s.floor(330);// greatest element in this set less than or equal to
        Integer ceiling = s.ceiling(330);// greatest element in this set less than or equal to
        System.out.println(ceiling); // null in this case
        System.out.println(floor);
        SortedSet<Integer> integers = s.tailSet(326);// subset greater or equal value
        System.out.println(integers);

        /*
         * PATH OPERATIONS
         */

        Stream<Path> findMyFile = Files.find(Paths.get("c:\\temp\\pathtest"), Integer.MAX_VALUE,
                (p, a) -> p.endsWith("test.txt") && a.isRegularFile());
        Stream<Path> findMyFileSecond = Files.walk(Paths.get("c:\\temp\\pathtest"), Integer.MAX_VALUE).filter(p -> p.endsWith("test.txt")); //find takes three arguments

        findMyFile.forEach(System.out::println);
        findMyFileSecond.forEach(System.out::println);

        /*
         * FUNCTIONAL PROGRAMMING
         */

        List<String> strings = Arrays.asList("test1", "test2", "test3");
        int sum = strings.stream().mapToInt(i -> i.length() > 5 ? i.length() : 0).sum();
        int sum2 = strings.stream().mapToInt(String::length).filter(i -> i > 5).sum();

        System.out.println(sum);

        List<String> letters = Arrays.asList("j", "a", "v", "a");

        letters.forEach(letter -> letter.toUpperCase()); // doesnt work because result isnt used
        letters.forEach(System.out::print);

        System.out.print(letters.stream().collect(Collectors.joining()).toUpperCase());

        UnaryOperator<String> uo = str -> str.toUpperCase();
        letters.replaceAll(uo); // replace all aplies the function to every element in the collection
        letters.forEach(System.out::print);

        /*
         * ASSERTIONS
         */

        //<boolean_expression> : <any_expression_but_void>
        int value = 5;
        boolean flag = false;
        assert flag : null; // what is possible on the right side of the assertion? quite everything
        // is it used in the assertionError?





        /*
        DATE TIME OPERATIONS
         */
        // saving time change at 2 am
        LocalDateTime ld1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 2, 0);
        ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));
        LocalDateTime ld2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);
        ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern"));
        long diff = ChronoUnit.HOURS.between(zd1, zd2);
        System.out.println(diff); // -2



        /*
        IO, NIO2
         */
        Console c = System.console();
        String id = c.readLine("%s", "Enter UserId:"); //1
        System.out.println("userid is " + id); //2
        char[] pwd = c.readPassword("%s", "Enter Password :"); // return encryptet char array
        System.out.println("password is " + pwd); //4

        /*
        CONCURRENCY
         */
        //FORK JOIN SAMPLE
