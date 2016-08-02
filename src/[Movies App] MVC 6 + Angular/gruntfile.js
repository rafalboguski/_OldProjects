/// <binding />
module.exports = function (grunt) {
    // load Grunt plugins from NPM
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-copy');

    // configure plugins
    grunt.initConfig({
        uglify: {
            my_target: {
                files: { 'wwwroot/app.js': ['Scripts/app.js', 'Scripts/**/*.js'] }
            }
        },
        copy: {
            files: {
                cwd: 'Scripts/'  ,
                src: ['**/*.html','**/*.css'],
                dest: 'wwwroot',
                expand: true
            }
        },

        watch: {
            scripts: {
                files: ['Scripts/**/*.js'],
                tasks: ['uglify','copy']
            }
        }
    });

    // define tasks
    grunt.registerTask('default', ['uglify','copy', 'watch']);
};