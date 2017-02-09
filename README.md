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
