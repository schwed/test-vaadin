/**
 * Created by kshevchuk on 3/30/2016.
 */
window.com_kon_vaa_generation_sankey_SankeyDiagram = function() {

    var diagramElement = this.getElement();
    var graph = {"nodes" : [], "links" : []};

    // Handle changes from the server-side
    // re-draws the sankey using the state variable sankeydata
    this.onStateChange = function() {
        var sankeydata = JSON.parse(this.getState().sankeyData);
        console.log("json data: ",sankeydata);


        //this.buildSankey(diagramElement, sankeydata);
        buildNodes(sankeydata, graph);
        buildLinks(sankeydata, graph);
        buildSankey(graph)
    };

    function buildNodes(sankeyData, graph) {
        sankeyData.nodes.forEach(function(d, i) {
            graph.nodes.push({"name": d.name});
        });
    };

    function buildLinks(sankeyData, graph) {

        sankeyData.links.forEach(function(d, i) {

            graph.links.push({
                "source": d.source,
                "target": d.target,
                "value": d.value
            });
        });
    }

    function buildSankey(graph) {
        function a(a) {
            d3.select(this).attr("transform", "translate(" + a.x + "," + (a.y = Math.max(0, Math.min(j - a.dy, d3.event.y))) + ")"),
                m.relayout(),
                p.attr("d", o)
        }
        function b(a) {
            n.transition().duration(200).style("opacity", .95),
                n.html("<div class='popup-label'>"
                    + "LINEAGE"
                    + "</div><div class='popup-line'><span class='popup-label'>Source</span><span class='popup-value'>"
                    + a.source.name
                    + "</span></div><div class='popup-line'><span class='popup-label'>Target</span><span class='popup-value'>"
                    + a.target.name
                    + "</span></div><div class='popup-line'><span class='popup-label'>Weight </span><span class='popup-value'>"
                    + a.value.toFixed(1) + "</span></div><div class='popup-line'><span class='popup-label'>ID </span><span class='popup-value'>"
                    + a.source.name + " -> " + a.target.name
                    + "</span></div><div class='popup-line'><span class='popup-label'>Confidence </span><span class='popup-value'>"
                    + a.value + "</span></div>").style("left", d3.event.pageX
                    + 15 + "px").style("top", d3.event.pageY - 28 + "px")
        }
        function c(a) {
            n.transition().duration(200).style("opacity", .95),
                n.html("<div class='popup-label'>"
                    + a.name.toUpperCase()
                    + " (" + a.name
                    + ")</div><div class='popup-line'><span class='popup-title'>"
                    + a.name
                    + "</span></div><div class='popup-line'><span class='popup-label'>ID</span><span class='popup-value'>"
                    + a.name + "</span></div><div class='popup-line'><span class='popup-label'>Weight </span><span class='popup-value'>"
                    + a.value.toFixed(0) + "</span></div>").style("left", d3.event.pageX + 15
                    + "px").style("top", d3.event.pageY - 28 + "px")
        }
        function d() {
            n.transition().duration(500).style("opacity", 0)
        }

        // --------------------------------------------------------- //


        var nodeMap = {};
        graph.nodes.forEach(function (x) {
            nodeMap[x.name] = x;
        });
        graph.links = graph.links.map(function (x) {
            return {
                source: nodeMap[x.source],
                target: nodeMap[x.target],
                value: x.value
            };
        });

        var f = graph.nodes,
            g = graph.links;

        console.log("graph Nodes: " + f.length),
            console.log("graph Links: " + g.length);

        var h = {
            top: 5,
            right: 300,
            bottom: 5,
            left: 200
        }
            , i = 1300 - h.left - h.right
            , j = 10 * f.length - h.top - h.bottom
            , k = (d3.format(",.0f"), d3.scale.category20())
            , l = d3.select(diagramElement).append("svg").attr("width", i + h.left + h.right).attr("height", j + h.top + h.bottom).append("g").attr("transform", "translate(" + h.left + "," + h.top + ")")
            , m = d3.sankey().nodeWidth(10).nodePadding(10).size([i, j])
            , n = d3.select(diagramElement).append("div").attr("class", "popup").style("opacity", 0)
            , o = m.link();


        m.nodes(f).links(g).layout(32);
        var p = l.append("g")
            .selectAll(".link")
            .data(g)
            .enter()
            .append("path")
            .attr("class", "link")
            .attr("d", o)
            .style("stroke-width", function(a) {
                return Math.max(1, a.dy)
            })
            /*
             .style("stroke", function(d) {
             if (d.value > 80)
             return "#00FF00";
             return "#000";
             })*/
            .sort(function(a, b) {
                return b.dy - a.dy
            })
            .on("mouseover", function(a) {
                b(a)
            })
            .on("mouseout", function(a) {
                d(a)
            })
            ,
            q = l.append("g")
                .selectAll(".node")
                .data(f)
                .enter()
                .append("g")
                .attr("class", "node")
                .attr("transform", function(a) {
                    return "translate(" + a.x + "," + a.y + ")"
                })
                .call(d3.behavior
                    .drag()
                    .origin(function(a) {
                        return a
                    })
                    .on("dragstart", function() {
                        this.parentNode.appendChild(this)
                    })
                    .on("drag", a))
                .on("click", function(a) {
                    window.open(a.name, "_self", !0);
                    //alert("Clicked!");
                })
                .on("mouseover", function(a) {
                    c(a)
                })
                .on("mouseout", function(a) {
                    d(a)
                })
                .on("contextmenu", function(a) {
                    window.open("/#dummy/" + a.name, "_self", !0),
                        d3.event.preventDefault()
                });
        return q.append("rect")
            .attr("height", function(a) {
                return a.dy
            })
            .attr("width", m.nodeWidth()).style("fill", function(a) {
                return a.color = k(a.name.toString().replace(/ .*/, ""))
            })
            .style("stroke", function(a) {
                return d3.rgb(a.color).darker(2)
            }),
            q.append("text")
                .attr("x", 16).attr("y", function(a) {
                    return a.dy / 2
                })
                .attr("dy", ".35em")
                .attr("text-anchor", "start")
                .attr("transform", null )
                .text(function(a) {
                    return a.name
                })
                .filter(function(a) {
                    return a.x < i / 2
                })
                .attr("x", 0 - m.nodeWidth())
                .attr("text-anchor", "end"),
            //$(this.el).append(this.template()),
            this
    }



    d3.sankey = function () {
        function a() {
            n.forEach(function (a) {
                a.sourceLinks = [], a.targetLinks = []
            }),

                o.forEach(function (a) {
                    var b = a.source, c = a.target;
                    "number" == typeof b && (b = a.source = n[a.source]),
                    "number" == typeof c && (c = a.target = n[a.target]),
                        b.sourceLinks.push(a), c.targetLinks.push(a)
                })
        }

        function b() {
            n.forEach(function (a) {
                a.value = Math.max(d3.sum(a.sourceLinks, i), d3.sum(a.targetLinks, i))
            })
        }

        function c() {
            function a(d) {
                if (d.index = c++,
                        d.lowIndex = d.index,
                        d.onStack = !0,
                        b.push(d),
                    d.sourceLinks && (d.sourceLinks.forEach(function (b) {
                        var c = b.target;
                        c.hasOwnProperty("index") ? c.onStack && (d.lowIndex = Math.min(d.lowIndex, c.index)) : (a(c), d.lowIndex = Math.min(d.lowIndex, c.lowIndex))
                    }),
                    d.lowIndex === d.index)
                ) {
                    var e, f = [];
                    do e = b.pop(), e.onStack = !1, f.push(e);
                    while (e != d);
                    p.push({root: d, scc: f})
                }
            }

            var b = [], c = 0;
            n.forEach(function (b) {
                b.index || a(b)
            }),
                p.forEach(function (a, b) {
                    a.index = b,
                        a.scc.forEach(function (a) {
                            a.component = b
                        })
                })
        } // end of function c

        function d() {
            function a() {
                for (var a, b, c = p, d = 0; c.length;)
                    a = [], b = {},
                        c.forEach(function (c) {
                            c.x = d,
                                c.scc.forEach(function (d) {
                                    d.sourceLinks.forEach(function (d) {
                                        b.hasOwnProperty(d.target.component) || d.target.component == c.index || (a.push(p[d.target.component]), b[d.target.component] = !0)
                                    })
                                })
                        }),
                        c = a,
                        ++d

            }

            function b(a, b) {
                for (var c = [a], d = 1, e = 0, f = 0; d > 0;) {
                    var g = c.shift();
                    if (d--, !g.hasOwnProperty("x")) {
                        g.x = f, g.dx = k;
                        var h = b(g);
                        c = c.concat(h), e += h.length
                    }
                    0 == d && (f++, d = e, e = 0)
                }
            }

            a(),
                p.forEach(function (a, c) {
                    b(a.root, function (a) {
                        var b = a.sourceLinks.filter(function (a) {
                            return a.target.component == c
                        }).map(function (a) {
                            return a.target
                        });
                        return b
                    })
                });
            var c = 0, d = d3.nest().key(function (a) {
                return a.x
            }).sortKeys(d3.ascending).entries(p).map(function (a) {
                return a.values
            }), c = -1, f = -1;
            d.forEach(function (a) {
                a.forEach(function (a) {
                    a.x = c + 1, a.scc.forEach(function (b) {
                        b.x = a.x + b.x, f = Math.max(f, b.x)
                    })
                }), c = f
            }),
                n.filter(function (a) {
                    var b = a.sourceLinks.filter(function (a) {
                        return a.source.name != a.target.name
                    });
                    return 0 == b.length
                }).forEach(function (a) {
                    a.x = c
                }), e((m[0] - k) / Math.max(c, 1))
        } // end of function d

        function e(a) {
            n.forEach(function (b) {
                b.x *= a
            })
        }

        function f(a) {
            function b() {
                var a = d3.min(g, function (a) {
                    return (m[1] - (a.length - 1) * l) / d3.sum(a, i)
                });
                g.forEach(function (b) {
                    b.forEach(function (b, c) {
                        b.y = c, b.dy = b.value * a
                    })
                }), o.forEach(function (b) {
                    b.dy = b.value * a
                })
            }

            function c(a) {
                function b(a) {
                    return h(a.source) * a.value
                }

                g.forEach(function (c) {
                    c.forEach(function (c) {
                        if (c.targetLinks.length) {
                            var d = d3.sum(c.targetLinks, b) / d3.sum(c.targetLinks, i);
                            c.y += (d - h(c)) * a
                        }
                    })
                })
            }

            function d(a) {
                function b(a) {
                    return h(a.target) * a.value
                }

                g.slice().reverse().forEach(function (c) {
                    c.forEach(function (c) {
                        if (c.sourceLinks.length) {
                            var d = d3.sum(c.sourceLinks, b) / d3.sum(c.sourceLinks, i);
                            c.y += (d - h(c)) * a
                        }
                    })
                })
            }

            function e() {
                g.forEach(function (a) {
                    var b, c, d, e = 0, g = a.length;
                    for (a.sort(f), d = 0; g > d; ++d)
                        b = a[d], c = e - b.y, c > 0 && (b.y += c), e = b.y + b.dy + l;
                    if (c = e - l - m[1], c > 0)
                        for (e = b.y -= c, d = g - 2; d >= 0; --d)
                            b = a[d], c = b.y + b.dy + l - e, c > 0 && (b.y -= c), e = b.y
                })
            }

            function f(a, b) {
                return a.y - b.y
            }

            var g = d3.nest().key(function (a) {
                return a.x
            }).sortKeys(d3.ascending).entries(n).map(function (a) {
                return a.values
            });
            b(), e();
            for (var j = 1; a > 0; --a)
                d(j *= .99), e(), c(j), e()
        } // end of function f

        function g() {
            function a(a, b) {
                return a.source.y - b.source.y
            }

            function b(a, b) {
                return a.target.y - b.target.y
            }

            n.forEach(function (c) {
                c.sourceLinks.sort(b), c.targetLinks.sort(a)
            }), n.forEach(function (a) {
                var b = 0, c = 0;
                a.sourceLinks.forEach(function (a) {
                    a.sy = b, b += a.dy
                }), a.targetLinks.forEach(function (a) {
                    a.ty = c, c += a.dy
                })
            })
        } // end of function g

        function h(a) {
            return a.y + a.dy / 2
        }

        function i(a) {
            return a.value
        }

        var j = {}, k = 24, l = 8, m = [1, 1], n = [], o = [], p = [];


        return j.nodeWidth = function (a) {
            return arguments.length ? (k = +a, j) : k
        },
            j.nodePadding = function (a) {
                return arguments.length ? (l = +a, j) : l
            },
            j.nodes = function (a) {
                return arguments.length ? (n = a, j) : n
            },
            j.links = function (a) {
                return arguments.length ? (o = a, j) : o
            },
            j.size = function (a) {
                return arguments.length ? (m = a, j) : m
            },
            j.layout = function (e) {
                return a(), b(), c(), d(), f(e), g(), j
            },
            j.relayout = function () {
                return g(), j
            },
            j.reversibleLink = function () {
                function a(a, b) {
                    var d = b.source.x + b.source.dx, e = b.target.x, f = d3.interpolateNumber(d, e), g = f(c), h = f(1 - c), i = b.source.y + b.sy, j = b.target.y + b.ty, k = b.source.y + b.sy + b.dy, l = b.target.y + b.ty + b.dy;
                    switch (a) {
                        case 0:
                            return "M" + d + "," + i + "L" + d + "," + (i + b.dy);
                        case 1:
                            return "M" + d + "," + i + "C" + g + "," + i + " " + h + "," + j + " " + e + "," + j + "L" + e + "," + l + "C" + h + "," + l + " " + g + "," + k + " " + d + "," + k + "Z";
                        case 2:
                            return "M" + e + "," + j + "L" + e + "," + (j + b.dy)
                    }
                }

                function b(a, b) {
                    function c(a) {
                        return a.source.y + a.sy > a.target.y + a.ty ? -1 : 1
                    }

                    function d(a, b) {
                        return a + "," + b + " "
                    }

                    var e = 30, f = 15, g = c(b) * f, h = b.source.x + b.source.dx, i = b.source.y + b.sy, j = b.target.x, k = b.target.y + b.ty;
                    switch (a) {
                        case 0:
                            return "M" + d(h, i) + "C" + d(h, i) + d(h + e, i) + d(h + e, i + g) + "L" + d(h + e, i + g + b.dy) + "C" + d(h + e, i + b.dy) + d(h, i + b.dy) + d(h, i + b.dy) + "Z";
                        case 1:
                            return "M" + d(h + e, i + g) + "C" + d(h + e, i + 3 * g) + d(j - e, k - 3 * g) + d(j - e, k - g) + "L" + d(j - e, k - g + b.dy) + "C" + d(j - e, k - 3 * g + b.dy) + d(h + e, i + 3 * g + b.dy) + d(h + e, i + g + b.dy) + "Z";
                        case 2:
                            return "M" + d(j - e, k - g) + "C" + d(j - e, k) + d(j, k) + d(j, k) + "L" + d(j, k + b.dy) + "C" + d(j, k + b.dy) + d(j - e, k + b.dy) + d(j - e, k + b.dy - g) + "Z"
                    }
                }

                var c = .5;
                return function (c) {
                    return function (d) {
                        return d.source.x < d.target.x ? a(c, d) : b(c, d)
                    }
                }
            },
            j.link = function () {
                function a(a) {
                    var c = a.source.x + a.source.dx, d = a.target.x, e = d3.interpolateNumber(c, d), f = e(b), g = e(1 - b), h = a.source.y + a.sy + a.dy / 2, i = a.target.y + a.ty + a.dy / 2;
                    return "M" + c + "," + h + "C" + f + "," + h + " " + g + "," + i + " " + d + "," + i
                }

                var b = .5;
                return a.curvature = function (c) {
                    return arguments.length ? (b = +c, a) : b
                }, a
            }, j
    };

};
